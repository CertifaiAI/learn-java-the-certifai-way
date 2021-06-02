/*
 * #
 * #    Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 * #
 * #    This program is part of OSRFramework. You can redistribute it and/or modify
 * #    it under the terms of the GNU Affero General Public License as published by
 * #    the Free Software Foundation, either version 3 of the License, or
 * #    (at your option) any later version.
 * #
 * #    This program is distributed in the hope that it will be useful,
 * #    but WITHOUT ANY WARRANTY; without even the implied warranty of
 * #    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * #    GNU Affero General Public License for more details.
 * #
 * #    You should have received a copy of the GNU Affero General Public License
 * #    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #
 *
 */
package ai.certifai.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Input parser
 *
 * @author codenamewei
 */
@Slf4j
public class InputParser {

    private boolean classInit = true;

    private String input;
    private BufferedReader br;

    @Getter private int currentUseCase = 1;

    @Getter private int totalUseCases;
    @Getter private boolean isMultiLine;

    //multipleLine
    private int multiLinesBuffer = 0;
    private int currentUseCaseTotalLines = 1;

    public InputParser(Class class_)
    {
        File file = FileLoader.getInputLoader(class_);

        try
        {
            br = new BufferedReader(new FileReader(file));

            String inputBuffer = br.readLine();

            String[] input = inputBuffer.trim().split("\\s+");

            if(input.length != 2)
            {
                log.info("Input text file failed with not 2 input. Program expected to failed");
            }

            totalUseCases = Integer.parseInt(input[0]);
            isMultiLine = Boolean.parseBoolean(input[1]);

            if(isMultiLine)
            {
                currentUseCaseTotalLines = Integer.parseInt(br.readLine());
            }

        }
        catch(Exception e)
        {
            log.info("Error occurs during declare BufferedReader: " + e);
        }
    }

    private boolean getInputFromFile()
    {
        try
        {
            if(!isMultiLine)
            {
                input = br.readLine();

                if (input == null)
                {
                    throw new Exception("Single line reader end early. Something wrong");
                }
                else
                {
                    singleLineAddUseCase();
                }
            }
            else
            {
                if (multiLinesBuffer < currentUseCaseTotalLines)
                {
                    try
                    {
                        input = br.readLine();

                        if (input == null)
                        {
                            throw new Exception("Multi line reader end early. Something wrong");
                        }
                        else
                        {
                            ++multiLinesBuffer;
                        }
                    }
                    catch (Exception e)
                    {
                        log.info(e.getMessage());
                    }
                }
                else {
                    return false;
                }
            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
            return false;
        }

        return true;
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

    public String getStringInput()
    {
        if(getInputFromFile())
        {
            return input;
        }
        else
        {
            return "-1";
        }
    }

    public int getIntegerInput()
    {
        try
        {
            if(getInputFromFile())
            {
                return Integer.parseInt(input);
            }
        }
        catch(Exception e)
        {
            log.info("Input cannot parse to integer", e.getMessage());
        }

        return -1;
    }

    public double getDoubleInput()
    {
        try
        {
            if(getInputFromFile())
            {
                return Double.parseDouble(input);
            }
        }
        catch(Exception e)
        {
            log.info("Input cannot parse to double", e.getMessage());
        }

        return -1D;
    }

    public float getFloatInput()
    {
        try
        {
            if(getInputFromFile())
            {
                return Float.parseFloat(input);
            }
        }
        catch(Exception e)
        {
            log.info("Input cannot parse to float", e.getMessage());
        }

        return -1F;
    }

    private void singleLineAddUseCase()
    {
        if(currentUseCase < totalUseCases) ++currentUseCase;
    }

    public int getCurrentUseCaseTotalLines()
    {
        if (currentUseCase >= totalUseCases)
        {
            log.info("Use Case ended. No more valid input");

            return 0;
        }

        if((!isMultiLine) && (currentUseCase < totalUseCases))
        {
            ++currentUseCase;
        }
        else if(!classInit)
        {
            try
            {
                flushLine(currentUseCaseTotalLines - multiLinesBuffer);
                multiLinesBuffer = 0;

                String buffer;
                if((buffer = br.readLine()) == null)
                {
                    log.info("Retriving number of total lines for current use case is null");

                    return 0;
                }
                else
                {
                    currentUseCaseTotalLines = Integer.parseInt(buffer);
                    singleLineAddUseCase();
                }

            }
            catch(Exception e)
            {
                log.info(e.getMessage());
            }
        }
        else
        {
            classInit = false;
        }

        return currentUseCaseTotalLines;
    }
}
