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

import ai.certifai.util.Evaluation;

/**
 * If - Else If - Else Loop
 */
public class If_ElseIf_Else
{
    static Evaluation eval;
    //static InputReader in;

    public static void main(String[] args)
    {
        /*
        in = new InputReader(If_ElseIf_Else.class);
        eval = new Evaluation(If_ElseIf_Else.class, in);

        int totalUseCases = in.getNumOfUseCase();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String input = in.getInputPerLine();

            eval.evaluatePerUseCase(compute(Integer.parseInt(input)));
        }

        eval.printResult();
        */
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
