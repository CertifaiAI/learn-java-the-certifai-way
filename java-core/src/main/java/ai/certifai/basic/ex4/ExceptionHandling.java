package ai.certifai.basic.ex4;

import ai.certifai.util.Evaluation;

import java.io.File;

public class ExceptionHandling
{
    static Evaluation eval = new Evaluation(ExceptionHandling.class);

    public static void main(String[] args)
    {
        String filePathInString = "metadata/sample.txt"; //FILE DID NOT EXIST

        File filePath = new File(filePathInString);

        //Rewrite the statement below onwards to catch the exceptino with try-catch-finally
        System.out.println(filePath.getAbsolutePath());
    }
}
