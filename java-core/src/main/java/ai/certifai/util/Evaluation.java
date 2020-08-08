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

    public void evaluatePerLine(String output)
    {
        try {
            String trueOutput;

            if((trueOutput = br.readLine()) != null)
            {
                System.out.println("Case " + caseNumber++);

                System.out.println("Output     : " + output);
                System.out.println("True Output: " + trueOutput);

                if(output.equals(trueOutput))
                {
                    truthCaseNumber++;
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
}
