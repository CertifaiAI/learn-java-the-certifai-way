package ai.certifai.basic.ex4_;

import ai.certifai.util.Evaluation;

import java.io.File;
import java.util.Scanner;

public class ExceptionHandling
{
    static Evaluation eval = new Evaluation(ExceptionHandling.class);

    public static void main(String[] args) throws Exception
    {
        String filePathInString = "metadata/sample.txt"; //FILE DID NOT EXIST

        //Rewrite the statement below onwards to catch the exception with try-catch-finally
        File filePath = new File(filePathInString);
        Scanner input = new Scanner(filePath);

        //Write try-finally-catch from here onwards

        eval.printResult();
    }
}
