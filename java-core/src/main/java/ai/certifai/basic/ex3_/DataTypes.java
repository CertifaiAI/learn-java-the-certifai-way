package ai.certifai.basic.ex3_;

import ai.certifai.util.Evaluation;

public class DataTypes
{
    static Evaluation eval = new Evaluation(DataTypes.class);

    public static void main(String[] args)
    {
        String inputString = "Nasi Lemak!";
        eval.evaluatePerLine(inputString);

        //Enter your code here

        eval.printResult();
    }
}
