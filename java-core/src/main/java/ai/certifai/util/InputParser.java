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
    private boolean isMultiLine;

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

    private boolean getInputFromFile() {

        try
        {
            if (multiLinesBuffer < currentUseCaseTotalLines)
            {
                try
                {
                    input = br.readLine();

                    if (input == null)
                    {
                        log.info("Multi line reader end early. Something wrong");
                    } else {
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
        catch(Exception e)
        {
            log.info(e.getMessage());
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

    public int getCurrentUseCaseTotalLines()
    {
        if (currentUseCase >= totalUseCases)
        {
            log.info("Use Case ended. No more valid input");

            return 0;
        }

        if (!isMultiLine)
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
                    ++currentUseCase;
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
