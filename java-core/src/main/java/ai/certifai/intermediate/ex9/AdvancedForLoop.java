/*
 * #
 * #    Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 * #
 * #    This program is part of OSRFramework. You can redistribute it and/or modify
 * #    it under the terms of the GNU Affero General Public License as published by
 * #    the Free Software Foundation, either version 3 of the License, or
 * #    (at your option) any later version.
 * #
 * #    This program is distributed in the hope that it will be useful,
 * #    but WITHOUT ANY WARRANTY; without even the implied warranty of
 * #    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * #    GNU Affero General Public License for more details.
 * #
 * #    You should have received a copy of the GNU Affero General Public License
 * #    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #
 *
 */
package ai.certifai.intermediate.ex9;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.util.List;

/**
 * Advanced For Loop
 *
 * @author codenamewei
 */
public class AdvancedForLoop
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(AdvancedForLoop.class);
        out = new OutputParser(AdvancedForLoop.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<Integer> arrayInput = Conversion.StringToListInteger(line);

            int m = arrayInput.get(0);
            int n = arrayInput.get(1);
            int b = arrayInput.get(2);

            assessArrayValue(m, n, b);
        }

        out.printResult();
    }

    ////a_m = a_(m - 1) + 2^(n + m) + b
    public static void assessArrayValue(int m, int n, int b)
    {
        List<Integer> array = null;
        /**
         Modify your code in this function
         Do the accordingly changes to this function to reach the successful run of the code
         **/

        String output = Conversion.ListIntegerToString(array);

        out.evaluate(output);
    }
}
