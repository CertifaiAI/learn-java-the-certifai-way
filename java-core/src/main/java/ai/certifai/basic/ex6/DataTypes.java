package ai.certifai.basic.ex6;

import ai.certifai.util.Evaluation;

/**
 * Data Types
 *
 * @author codenamewei
 */
public class DataTypes
{
    static Evaluation eval = new Evaluation(DataTypes.class);

    public static void main(String[] args)
    {
        String inputString = "Nasi Lemak!";
        eval.evaluatePerLine(inputString);

        /*
        Enter your code here
         */

        eval.printResult();
    }
}
