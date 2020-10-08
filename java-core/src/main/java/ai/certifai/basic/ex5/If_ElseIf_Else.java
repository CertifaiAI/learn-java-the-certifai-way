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

import ai.certifai.basic.ex7.ForLoop;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * If - Else If - Else Loop
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

            String output = compute(input);

            System.out.println(output);

            out.evaluate(output);
        }

        out.printResult();
    }

    public static String compute(int input)
    {
        if((input >= 50) && (input <= 100))
        {
            return "Special";
        }
        else if(input > 10000)
        {
            return "Out of Range";
        }
        else if(input % 2 == 0)
        {
            return "Even";
        }
        else
        {
            return "Odd";
        }

        //return "";
    }
}
