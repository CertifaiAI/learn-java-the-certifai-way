/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. You should have received a copy of the
 * GNU Affero General Public License along with this program.  If not, see
 *
 *       https://www.gnu.org/licenses/agpl-3.0
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 */
package ai.certifai.intermediate.ex15;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.util.List;

class QuickSort
{
    /**
     Modify your code in this class
     Do the accordingly changes to reach the successful run of the code
     **/

    public List<Integer> sort(List<Integer> array, int beginIndex, int endIndex)
    {

        return null;
    }
}

/**
 Quick Sort
 *
 @author codenamewei
 */
public class QuickSortImp
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(QuickSortImp.class);
        out = new OutputParser(QuickSortImp.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<Integer> arrayInput = Conversion.StringToListInteger(line);

            List<Integer> arrayOutput = new QuickSort().sort(arrayInput, 0, arrayInput.size() - 1);

            out.evaluate(Conversion.ListIntegerToString(arrayOutput));

        }
        out.printResult();

    }
}