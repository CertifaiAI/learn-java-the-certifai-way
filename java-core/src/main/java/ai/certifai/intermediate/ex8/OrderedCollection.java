package ai.certifai.intermediate.ex8;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.util.List;

public class OrderedCollection
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(OrderedCollection.class);
        out = new OutputParser(OrderedCollection.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<Integer> arrayInput = Conversion.StringToListInteger(line);

            for(Integer input : arrayInput)
            {
                out.evaluate(input);
            }
        }

        out.printResult();
    }
}
