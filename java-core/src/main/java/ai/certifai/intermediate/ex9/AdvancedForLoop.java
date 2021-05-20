/*
 * Copyright (c) 2021 CertifAI Sdn. Bhd.
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
