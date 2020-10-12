/*
 * Copyright (c) 2020 CertifAI Sdn. Bhd.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
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