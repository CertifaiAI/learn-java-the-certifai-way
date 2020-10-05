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

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Evaluation 
 * 
 * @author codenamewei
 */
@Slf4j
public class Evaluation
{
    /*
    private int truthCaseNumber = 0;
    private int currentCaseNumber = 0;

    private InputReader inputReaderRef;
    private BufferedReader br;

    private boolean isMultiLineUseCaseTrue;
    private int multiLinesBuffer = -1; //buffer
    private int multiLinesPerUseCase = -1; //total number of lines of current use case -  for multi line use case

    private List<Boolean> results;

    public Evaluation(Class class_, InputReader in)
    {
        ClassLoader loader = class_.getClassLoader();

        inputReaderRef = in;

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.OUTPUT_FILE;

        File file = new File(loader.getResource(resourceFile).getFile());

        results = new ArrayList<Boolean>();

        try
        {
            br = new BufferedReader(new FileReader(file));

            if(in.isMultiLine())
            {
                Object buffer = br.readLine();

                multiLinesPerUseCase = Integer.parseInt((String) buffer);
                multiLinesBuffer = 0;
                isMultiLineUseCaseTrue = true; // true until a line prove to be wrong, then the rest of the use case is false

            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }


    }

    private void checkMultiLineNewUseCase()
    {
        try
        {
            if(++multiLinesBuffer == multiLinesPerUseCase)
            {
                results.add(isMultiLineUseCaseTrue);

                log.info(isMultiLineUseCaseTrue ? "Correct\n" : "Wrong\n");

                ++currentCaseNumber;
                multiLinesPerUseCase = Integer.parseInt(br.readLine());
                multiLinesBuffer = 0;
                isMultiLineUseCaseTrue = true;

            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }
    }

    private void flushMultiLine()
    {
        try
        {
            isMultiLineUseCaseTrue = false;
            while(currentCaseNumber < inputReaderRef.getCurrentUseCase())
            {
                while(multiLinesBuffer < multiLinesPerUseCase)
                {
                    br.readLine();

                    checkMultiLineNewUseCase();
                }
            }
        }
        catch(Exception e)
        {
            log.info(e.getMessage());
        }
    }


    private void evalMultiLine(Object output)
    {
        //check for case number now in reader and fast forward if necessary
        try {

            if(currentCaseNumber < inputReaderRef.getCurrentUseCase())
            {
                flushMultiLine();
            }
            else
            {

                String trueOutput = br.readLine();
                System.out.println("True Output: " + trueOutput);

                if(output instanceof String)
                {
                    if(!output.equals(trueOutput))
                    {
                        isMultiLineUseCaseTrue = false;
                    }
                }
                else if(output instanceof Integer)
                {
                    Integer nOutput = (Integer) output;
                    if(nOutput != Integer.parseInt(trueOutput))
                    {
                        isMultiLineUseCaseTrue = false;
                    }
                }
                else if(output instanceof Double)
                {
                    Double dTrueOutput = Double.parseDouble(trueOutput);
                    Double doubleOutput = dTrueOutput - (Double) output;
                    if (Math.abs(doubleOutput) > 0.000001)
                    {
                        isMultiLineUseCaseTrue = false;
                    }
                }
                else if(output instanceof Boolean) {

                    boolean boolTrueOutput = Boolean.parseBoolean(trueOutput);
                    boolean boolOutput = (Boolean) output;
                    if(boolOutput != boolTrueOutput)
                    {
                        isMultiLineUseCaseTrue = false;
                    }
                }
                else if(output == null)
                {
                    isMultiLineUseCaseTrue = false;
                }

                checkMultiLineNewUseCase();
            }
        }
        catch(Exception e)
        {
            log.info("Input error: " + e);
        }
    }
    private void evalSingleLine(Object output)
    {
        try {

            if(currentCaseNumber < inputReaderRef.getNumOfUseCase())
            {
                if(currentCaseNumber != inputReaderRef.getCurrentUseCase())
                {
                    throw new Exception("Exception of case number");
                }

                log.info("Case " + currentCaseNumber++);

                String trueOutput = br.readLine();

                if(output instanceof String)
                {
                    if(output.equals(trueOutput))
                    {
                        log.info("Correct\n");

                        truthCaseNumber++;

                        results.add(true);
                    }
                    else
                    {
                        printWrongResult(output, trueOutput);

                        results.add(false);
                    }
                }
                else if(output instanceof Integer)
                {
                    Integer nOutput = (Integer) output;
                    if(nOutput == Integer.parseInt(trueOutput))
                    {
                        log.info("Correct\n");

                        truthCaseNumber++;

                        results.add(true);
                    }
                    else
                    {
                        printWrongResult(output, trueOutput);

                        results.add(false);
                    }
                }
                else if(output instanceof Double)
                {
                    Double dTrueOutput = Double.parseDouble(trueOutput);
                    Double doubleOutput = dTrueOutput - (Double) output;
                    if (Math.abs(doubleOutput) <= 0.000001)
                    {
                        log.info("Correct");

                        truthCaseNumber++;
                        results.add(true);
                    }
                    else
                    {
                        printWrongResult(output, trueOutput);
                        results.add(false);
                    }
                }
                else if(output instanceof Boolean) {

                    boolean boolTrueOutput = Boolean.parseBoolean(trueOutput);
                    boolean boolOutput = (Boolean) output;
                    if(boolOutput == boolTrueOutput)
                    {
                        log.info("Correct\n");
                        results.add(true);

                        truthCaseNumber++;
                    }
                }
                else if(output == null)
                {
                    printWrongResult("null", trueOutput);
                    results.add(false);
                }


            }
            else
            {
                log.info("Output file reader ended before testing case does");
            }
        }
        catch(Exception e)
        {
            log.info("Input error: " + e);
        }
    }


    public void evaluatePerUseCase(Object output)
    {
        if(inputReaderRef.isMultiLine())
        {
            evalMultiLine(output);
        }
        else
        {
            evalSingleLine(output);
        }
    }

    private boolean flushEvaluationPerLine()
    {
        try {

            String output;

            if ((output = br.readLine()) != null) {
                while (output != null) {
                    results.add(false);

                    output = br.readLine();
                }
                log.info("Note: not all lines were tested");

                return false;
            }

        }catch(Exception e)
        {
            log.info(e.getMessage());
        }

        return true;
    }
    public void printResult()
    {
        log.info("*************************");

        boolean isTestDone = flushEvaluationPerLine();

        if (inputReaderRef.getNumOfUseCase() > currentCaseNumber) {
            flushEvaluationPerLine();
            log.info(Config.WRONG_MSG);
        }
        else if (!isTestDone)
        {
            log.info(Config.WRONG_MSG);
        }
        else if ((truthCaseNumber == currentCaseNumber) && isTestDone)
        {
            log.info(Config.RIGHT_MSG);
        }

        log.info("*************************");

        new Dashboard().show(results);
    }

    public void printWrongResult(Object output, Object trueOutput)
    {
        log.info("Wrong");
        log.info("Output     : " + output);
        log.info("True Output: " + trueOutput + "\n");
    }

     */
}
