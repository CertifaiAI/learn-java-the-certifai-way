package ai.certifai.basic.ex2;

import ai.certifai.util.Evaluation;
import ai.certifai.util.InputReader;

public class If_ElseIf_Else
{
    static Evaluation eval = new Evaluation(If_ElseIf_Else.class);

    public static void main(String[] args)
    {
        InputReader in = new InputReader(If_ElseIf_Else.class);

        while(true)
        {
            String input = in.getInputPerLine();

            if(input == null) break;

            eval.evaluatePerLine(compute(Integer.parseInt(input)));
        }

        eval.printResult();
    }

    public static String compute(int input)
    {
        /*
        Fill in this function.
        */
        return null;
    }
}
