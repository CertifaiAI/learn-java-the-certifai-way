package ai.certifai.basic;

import ai.certifai.util.Evaluation;

/**
 * Change parameter of firstString (line 14) to "Hello World"
 */
public class HelloWorld_0
{
    static Evaluation eval = new Evaluation(HelloWorld_0.class);

    public static void main(String[] args)
    {
        String firstString = "";

        eval.evaluatePerLine(firstString);
    }
}