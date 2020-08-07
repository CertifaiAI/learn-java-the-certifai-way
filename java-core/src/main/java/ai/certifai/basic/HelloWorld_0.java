package ai.certifai.basic;

import ai.certifai.util.Evaluation;

public class HelloWorld_0
{
    static Evaluation eval = new Evaluation(HelloWorld_0.class);

    public static void main(String[] args)
    {
        String firstString = "Hello World";

        eval.evaluatePerLine(firstString);
    }
}