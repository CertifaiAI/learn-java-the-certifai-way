package ai.certifai.intermediate.ex10;

import ai.certifai.util.OutputParser;

import java.io.File;
import java.util.Scanner;

public class ExceptionHandling
{
    public static void main(String[] args) throws Exception
    {
        OutputParser out = new OutputParser(ExceptionHandling.class);

        String filePathInString = "metadata/sample.txt"; //FILE DID NOT EXIST

        //Rewrite the statement below onwards to catch the exception with try-catch-finally
        File filePath = new File(filePathInString);
        Scanner input = new Scanner(filePath);

        out.printResult();
    }
}
