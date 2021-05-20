/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
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
package ai.certifai.intermediate.ex8;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.util.List;

/**
 * List ArrayList
 *
 * @author codenamewei
 */
public class OrderedCollection
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(OrderedCollection.class);
        out = new OutputParser(OrderedCollection.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<Integer> arrayInput = Conversion.StringToListInteger(line);

            iterate(arrayInput);
        }

        out.printResult();
    }

    public static void iterate(List<Integer> array)
    {
        /**
         Enter your code in this function
         Tips: out.evaluate({content}) has to be used for the program to be success
         **/
    }
}
