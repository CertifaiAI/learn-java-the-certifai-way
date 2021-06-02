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
package ai.certifai.intermediate.ex12;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map Loop
 *
 * @author codenamewei
 */
public class MapImp
{
    static OutputParser out;
    static InputParser in;
    static final String GET = "get";
    static final String DELETE = "delete";
    static final String ADD = "add";

    public static void main(String[] args) throws Exception
    {
        in = new InputParser(MapImp.class);
        out = new OutputParser(MapImp.class, in);

        Map keyValue = new HashMap<String, Integer>();

        initKeyValue(keyValue);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<String> arrayInput = Conversion.StringToListString(line);

            if(arrayInput.size() == 3)
            {
                configKeyValue(keyValue, arrayInput.get(0), arrayInput.get(1), arrayInput.get(2));
            }
            else if(arrayInput.size() == 2)
            {
                configKeyValue(keyValue, arrayInput.get(0), arrayInput.get(1), null);
            }
            else
            {
                throw new Exception("Array size not fall under expectation. Program not expected to work fine");
            }
        }

        out.printResult();
    }


    private static void configKeyValue(@NonNull Map keyValue, @NonNull String action, @NonNull String country, String phoneCode) {

        /**
         Modify your code in this function
         Do the accordingly changes to this function to reach the successful run of the code
         Tips: out.evaluate({content}) has to be used for the program to be success
         **/

    }

    private static void initKeyValue(Map keyValue)
    {
        keyValue.put("Italy", "39");
        keyValue.put("Malaysia", "60");
        keyValue.put("Indonesia", "62");
        keyValue.put("Singapore", "65");
        keyValue.put("China", "86");
        keyValue.put("Russia", "7");

    }
}