package ai.certifai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public class Evaluation
{
    private int truthCaseNumber = 0;
    private int caseNumber = 0;
    private BufferedReader br;

    public Evaluation(Class class_)
    {
        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.OUTPUT_FILE;

        File file = new File(Objects. requireNonNull(loader.getResource(resourceFile)).getFile());

        try
        {
            br = new BufferedReader(new FileReader(file));
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
                System.out.println("Case " + caseNumber++);

                if(output instanceof String)
                {
                    if(output.equals(trueOutput))
                    {
                        System.out.println("Correct\n");

                        truthCaseNumber++;
                    }
                    else
                    {
                        printWrongResult(output, trueOutput);
                    }
                }
                else if(output instanceof Integer)
                {
                    Integer nOutput = (Integer) output;
                    if(nOutput == Integer.parseInt(trueOutput))
                    {
                        System.out.println("Correct\n");

                        truthCaseNumber++;
                    }
                    else
                    {
                        printWrongResult(output, trueOutput);
                    }
                }

            }
            else
            {
                System.out.println("Output file reader and input number of lines not aligned");
            }
        }
        catch(Exception e)
        {
            System.out.println("Input error: " + e);
        }
    }

    public void printResult()
    {
        System.out.println("\n*************************");

        if(truthCaseNumber == caseNumber)
        {
            System.out.println(Config.RIGHT_MSG);
        }
        else
        {
            System.out.println(Config.WRONG_MSG);
        }

        System.out.println("*************************");
    }

    public void printWrongResult(Object output, Object trueOutput)
    {
        System.out.println("Wrong");
        System.out.println("Output     : " + output);
        System.out.println("True Output: " + trueOutput + "\n");
    }
}
