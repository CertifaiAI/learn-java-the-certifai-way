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
