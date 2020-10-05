/*
 * Copyright (c) 2020 CertifAI Sdn. Bhd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package ai.certifai.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private boolean classInit = true;

    private String output;
    private BufferedReader br;
    private InputParser in;

    private int currentUseCase = 1;

    @Getter private int totalUseCases;
    private boolean isMultiLine;

    //multipleLine
    private int multiLinesBuffer = 0;
    private int currentUseCaseTotalLines = 1;


    private boolean isCurrentUseCaseFalse = false;

    private List<Boolean> results;

    public OutputParser(Class class_, InputParser inputParser)
    {
        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.OUTPUT_FILE;

        File file = new File(loader.getResource(resourceFile).getFile());

        in = inputParser;

        try
        {
            br = new BufferedReader(new FileReader(file));

            try {
                String inputBuffer;

                if((inputBuffer = br.readLine()) != null)
                {
                    String[] output = inputBuffer.trim().split("\\s+");

                    if(output.length != 2)
                    {
                        log.info("output text file failed with not 2 output. Program expected to failed");
                    }

                    totalUseCases = Integer.parseInt(output[0]);
                    isMultiLine = Boolean.parseBoolean(output[1]);


                    if(totalUseCases != in.getTotalUseCases())
                    {
                        log.info("input use cases != output use cases. Program not able to work fine");
                        return;
                    }

                    results = new ArrayList<>();

                    if(isMultiLine)
                    {
                        currentUseCaseTotalLines = Integer.parseInt(br.readLine());
                    }
                }
                else
                {
                    log.info("BufferedReader ended while readLine() initiated");
                }
            }
            catch(Exception e)
            {
                log.info("Output error: " + e);
            }


        }
        catch(Exception e)
        {
            log.info("Error occurs during declare BufferedReader: " + e);
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
        for(int i = 0; i < numOfUseCase; ++i)
        {
            flushLine(currentUseCaseTotalLines - multiLinesBuffer);

            try
            {
                String buffer = br.readLine();
                if(buffer == null)
                {
                    log.info("Retriving number of total lines for current use case is null");

                }
                else
                {
                    if(isMultiLine)
                    {
                        currentUseCaseTotalLines = Integer.parseInt(buffer);
                        multiLinesBuffer = 0;
                        results.add(false);
                    }
                    ++currentUseCase;
                }

            }
            catch(Exception e)
            {
                log.info(e.getMessage());
            }
        }
        multiLinesBuffer = 0;

        if(currentUseCase != in.getCurrentUseCase())
        {
            log.info("Major error, output use case index != input use case index");
        }

    }

    public void evaluate(String input)
    {
        try
        {
            if(in.getCurrentUseCase() > totalUseCases) return; // use case ended do nothing

            if(in.getCurrentUseCase() < currentUseCase)
            {
                flushUseCase(currentUseCase - in.getCurrentUseCase());
            }
            else
            {
                if(isMultiLine)
                {
                    String trueOutput = getTrueOutput();
                    if((!isCurrentUseCaseFalse) && (!trueOutput.equals(input)))
                    {
                        isCurrentUseCaseFalse = true;
                    }

                    ++multiLinesBuffer;

                    if(multiLinesBuffer == currentUseCaseTotalLines)
                    {
                        results.add(!isCurrentUseCaseFalse);

                        ++currentUseCase;

                        if(currentUseCase <= totalUseCases)
                        {
                            String nextTotalLines;

                            if ((nextTotalLines = br.readLine()) == null)
                            {
                                log.info("Output line reader end early. Something wrong");
                            }

                            currentUseCaseTotalLines = Integer.parseInt(nextTotalLines);
                            multiLinesBuffer = 1;
                        }
                    }
                }
                else
                {
                    results.add(getTrueOutput().equals(input));

                    ++currentUseCase;

                }
            }
        }
            catch(Exception e)
        {
            log.info(e.getMessage());
        }
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

        if (currentUseCase < totalUseCases)
        {
            int numOfUseCasesSkip = totalUseCases - currentUseCase;

            for(int i = 0; i < numOfUseCasesSkip; ++i)
            {
                results.add(false);
            }
        }
        else if(isMultiLine && (multiLinesBuffer < currentUseCaseTotalLines))
        {
            results.add(false);
        }


        new Dashboard().show(results);
    }
}
