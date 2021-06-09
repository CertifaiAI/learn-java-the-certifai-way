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
package ai.certifai.intermediate.ex13;

import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * SubString
 *
 * @author codenamewei
 */
public class SubString
{
    static OutputParser out;
    static InputParser in;

    static final String FAIL_MESSAGE = "It's not a file!";

    public static void main(String[] args)
    {
        in = new InputParser(SubString.class);
        out = new OutputParser(SubString.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String input = in.getStringInput();

            out.evaluate(getExtensionIfExist(input));
        }

        out.printResult();
    }

    private static String getExtensionIfExist(String input)
    {
        /**
         Modify your code in this function
         Do the accordingly changes to this function to reach the successful run of the code
         Change the returning value in line 57
         **/
        return null;
    }
}
