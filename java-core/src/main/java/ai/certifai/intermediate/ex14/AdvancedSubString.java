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
package ai.certifai.intermediate.ex14;

import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * SubString
 *
 * @author codenamewei
 */
public class AdvancedSubString
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(AdvancedSubString.class);
        out = new OutputParser(AdvancedSubString.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String input = in.getStringInput();

            processString(input);
        }

        out.printResult();
    }

    private static void processString(String input)
    {
        String output = input.trim();

        output = output.replace(" ", "_");

        out.evaluate(getContentIfExist(output));
    }

    private static String getContentIfExist(String input)
    {
        Character charFinding = new Character('.');
        int beginningIndex = 0;

        while(beginningIndex < input.length())
        {
            Character c = new Character(input.charAt(beginningIndex));
            if(c.equals(charFinding))
            {
                break;
            }
            ++beginningIndex;
        }

        String subString = input.substring(0, beginningIndex);

        return subString;
    }
}
