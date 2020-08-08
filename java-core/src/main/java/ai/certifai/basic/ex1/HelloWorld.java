package ai.certifai.basic.ex1;

import ai.certifai.util.Evaluation;

public class HelloWorld
{
    static Evaluation eval = new Evaluation(HelloWorld.class);

    public static void main(String[] args)
    {
        String firstString = null; //Enter your code here

        eval.evaluatePerLine(firstString);

        eval.printResult();
    }
}