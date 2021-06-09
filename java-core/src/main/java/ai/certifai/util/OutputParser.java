/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package ai.certifai.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Output parser
 *
 * @author codenamewei
 */
@Slf4j
public class OutputParser
{
    private BufferedReader br;
    private InputParser in;

    private int currentUseCase = 1;

    @Getter private int totalUseCases;

    //multipleLine
    private boolean isMultiLine;

    private int multiLinesBuffer = 1;
    private int currentUseCaseTotalLines = 1; //default 1 line if not multi lines
    private boolean isCurrentUseCaseFalse = false; //if true, the rest of multi lines of this use case will not change the output

    private List<Boolean> results; //results of size totalUseCases after evaluation

    public OutputParser(Class class_)
    {
        this(class_, null);
    }

    public OutputParser(Class class_, InputParser inputParser)
    {
        File file = FileLoader.getOutputLoader(class_);
        in = inputParser;

        try
        {
            br = new BufferedReader(new FileReader(file));

            String inputBuffer = br.readLine();

            String[] output = inputBuffer.trim().split("\\s+");

            if(output.length != 2)
            {
                String paramErrorMessage = "output text file failed with not 2 output. Program expected to failed";

                throw new IOException(paramErrorMessage);
            }

            totalUseCases = Integer.parseInt(output[0]);
            isMultiLine = Boolean.parseBoolean(output[1]);

            if((in != null) && (totalUseCases != in.getTotalUseCases()))
            {
                String useCaseNotAligned = "Input use cases != output use cases. Program not able to work fine";

                throw new IOException(useCaseNotAligned);
            }

            results = new ArrayList<>();

            if(isMultiLine)
            {
                currentUseCaseTotalLines = Integer.parseInt(br.readLine());
            }

        }
        catch(Exception e)
        {
            log.info("Error occurs during declare BufferedReader: " + e.getMessage());
        }
    }

    private void flushLine(int numTimes)
    {
        try {
            if (numTimes < 0)
            {
                log.info("Flush line from negative values. ");
            }

            for(int i = 0; i < numTimes; ++i)
            {
                if(br.readLine() == null)
                {
                    log.info("BufferedReader null while flushing line");
                }
            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }
    }

    private void flushUseCase(int numOfUseCase)
    {
        if(numOfUseCase == 0) return;

        try
        {
            for(int i = 0; i < numOfUseCase; ++i)
            {
                if(isMultiLine) flushLine(currentUseCaseTotalLines - multiLinesBuffer + 1);

                    String buffer = br.readLine();
                    if(buffer == null)
                    {
                        throw new IOException("Retriving number of total lines for current use case is null");

                    }
                    else
                    {
                        if(isMultiLine)
                        {
                            currentUseCaseTotalLines = Integer.parseInt(buffer);
                            multiLinesBuffer = 1;
                            resultsAddValueIfValid(false);
                        }
                        else
                        {
                            resultsAddValueIfValid(false);
                        }
                        ++currentUseCase;
                    }

            }
            multiLinesBuffer = 1; //?

            if((in != null) && (currentUseCase != in.getCurrentUseCase()))
            {
                throw new Exception("Output use case index != input use case index");
            }

        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }

    }

    private void resultsAddValueIfValid(boolean state)
    {
        if(results.size() < totalUseCases)
        {
            results.add(state);
        }
        else
        {
            log.info("Results size is more than total use cases. State not saved");
        }
    }

    private boolean getResult(Object input)
    {
        boolean bResult = false;

        if(input instanceof String)
        {
            bResult = compareString((String) input);
        }
        else if(input instanceof Integer)
        {
            bResult = compareInteger((Integer) input);
        }
        else if(input instanceof Float)
        {
            bResult = compareFloat((Float) input);
        }
        else if(input instanceof Boolean)
        {
            bResult = compareBoolean((Boolean) input);
        }


        return bResult;
    }

    public void evaluate(Object input)
    {
        try
        {
            if(isMultiLine)
            {
                if(in == null)
                {
                    throw new Exception("Input parse is null. Program cant function well");
                }

                if(in.getCurrentUseCase() > totalUseCases)
                {
                    return; // use case ended do nothing
                }

                if(in.isMultiLine())
                {
                    if(in.getCurrentUseCase() > currentUseCase)
                    {
                        flushUseCase(in.getCurrentUseCase() - currentUseCase);
                    }
                    else if(in.getCurrentUseCase() < currentUseCase)
                    {
                        results.remove(results.size() - 1);
                        results.add(false);
                    }
                }

                if(multiLinesBuffer > currentUseCaseTotalLines)
                {
                    results.remove(results.size() - 1);
                    results.add(false);
                }
                else
                {
                    if((!isCurrentUseCaseFalse) && (!getResult(input)))
                    {
                        isCurrentUseCaseFalse = true;
                    }

                    ++multiLinesBuffer;

                    if(multiLinesBuffer == (currentUseCaseTotalLines + 1) )
                    {
                        resultsAddValueIfValid(!isCurrentUseCaseFalse);

                        ++currentUseCase;

                        if(currentUseCase <= totalUseCases)
                        {
                            String nextTotalLines = br.readLine();

                            if (nextTotalLines == null)
                            {
                                log.info("Output line reader end early. Something wrong");
                            }
                            else
                            {
                                currentUseCaseTotalLines = Integer.parseInt(nextTotalLines);
                                multiLinesBuffer = 1;
                            }
                        }
                    }
                }
            }
            else
            {
                flushSingleLineUseCase();
                resultsAddValueIfValid(getResult(input));

                ++currentUseCase;

            }
        }
        catch(Exception e)
        {
            log.info("Error: " + e.getMessage());
        }

    }

    private void flushSingleLineUseCase()
    {
        if(in == null) return;

        if( (currentUseCase != totalUseCases) && (in.getCurrentUseCase() > (currentUseCase + 1)))
        {
            int numOfUseCaseToFlush = in.getCurrentUseCase() - currentUseCase - 1;

            flushUseCase(numOfUseCaseToFlush);
        }
    }


    private boolean compareString(String input)
    {
        String trueOutput = getTrueOutput();

        return trueOutput.equals(input);
    }


    private boolean compareInteger(Integer input)
    {
        String trueOutput = getTrueOutput();

        return input.equals(Integer.parseInt(trueOutput));
    }

    private boolean compareFloat(Float input)
    {
        String trueOutput = getTrueOutput();

        return input.equals(Float.parseFloat(trueOutput));
    }

    private boolean compareBoolean(Boolean input)
    {
        String trueOutput = getTrueOutput();

        return input == Boolean.parseBoolean(trueOutput);
    }

    private String getTrueOutput() {

        String outputBuffer = "";

        try
        {
            outputBuffer = br.readLine();

            if (outputBuffer == null)
            {
                log.info("Output line reader end early. Something wrong");
            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }

        return outputBuffer;

    }


    public void printResult()
    {
        if (currentUseCase <= totalUseCases)
        {
            int numOfUseCasesSkip = totalUseCases - currentUseCase + 1;

            for (int i = 0; i < numOfUseCasesSkip; ++i) {
                resultsAddValueIfValid(false);
            }
        }
        else if(isMultiLine && (currentUseCase == totalUseCases) && (multiLinesBuffer <= currentUseCaseTotalLines))
        {
            resultsAddValueIfValid(false);
        }

        new Dashboard().show(results);
    }
}
