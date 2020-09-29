package ai.certifai.util;

import javax.xml.transform.Result;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Evaluation
{
    private int totalCaseNumber = -1;
    private int truthCaseNumber = 0;
    private int caseNumber = 0;
    private boolean isIndependentCase;
    private BufferedReader br;
    private List<Boolean> results;

    public Evaluation(Class class_, boolean isCase)
    {
        this(class_);
        isIndependentCase = isCase;
    }

    public Evaluation(Class class_)
    {
        isIndependentCase = true;

        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.OUTPUT_FILE;

        File file = new File(loader.getResource(resourceFile).getFile());

        results = new ArrayList<Boolean>();

        try
        {
            br = new BufferedReader(new FileReader(file));

            String bufferTotalCase;

            if((bufferTotalCase = br.readLine()) != null) {

                totalCaseNumber = Integer.parseInt(bufferTotalCase);

                System.out.println("Total Lines Check: " + totalCaseNumber);

            }

        }
        catch(Exception e)
        {
            System.out.println("Error occurs during declare BufferedReader: " + e);
        }
    }

    public void evaluatePerLine(Object output)
    {
        try {
            String trueOutput;

            if((trueOutput = br.readLine()) != null)
            {
                ++caseNumber;
                if(isIndependentCase) System.out.println("Case " + caseNumber);

                if(output instanceof String)
                {
                    if(output.equals(trueOutput))
                    {
                        System.out.println("Correct\n");

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
                        System.out.println("Correct\n");

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
                        System.out.println("Correct\n");

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
                        System.out.println("Correct\n");
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
                System.out.println("Output file reader ended before testing case does");
            }
        }
        catch(Exception e)
        {
            System.out.println("Input error: " + e);
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
                System.out.println("Note: not all lines were tested");

                return false;
            }

        }catch(Exception e)
        {

            System.out.println(e);
        }

        return true;
    }
    public void printResult()
    {
        System.out.println("*************************");

        boolean isTestDone = flushEvaluationPerLine();

        if (totalCaseNumber > caseNumber) {
            flushEvaluationPerLine();
            System.out.println(Config.WRONG_MSG);
        }
        else if (!isTestDone)
        {
            System.out.println(Config.WRONG_MSG);
        }
        else if ((truthCaseNumber == caseNumber) && isTestDone)
        {
            System.out.println(Config.RIGHT_MSG);
        }

        System.out.println("*************************");

        new Dashboard().show(results);
    }

    public void printWrongResult(Object output, Object trueOutput)
    {
        System.out.println("Wrong");
        System.out.println("- Output     : " + output);
        System.out.println("- True Output: " + trueOutput + "\n");
    }
}
