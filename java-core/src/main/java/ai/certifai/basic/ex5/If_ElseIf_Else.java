/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package ai.certifai.basic.ex5;

import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * If - Else If - Else Loop
 *
 * @author codenamewei
 */
public class If_ElseIf_Else
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(If_ElseIf_Else.class);
        out = new OutputParser(If_ElseIf_Else.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            int input = in.getIntegerInput();

            System.out.println(input);
            String output = compute(input);

            out.evaluate(output);
        }

        out.printResult();
    }

    public static String compute(int input)
    {
        /**
         Enter your code here to complete this function
         Uncomment placeholder line 56 when done
         **/
        return "";
    }
}
