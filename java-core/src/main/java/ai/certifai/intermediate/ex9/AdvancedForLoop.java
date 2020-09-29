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
package ai.certifai.intermediate.ex9;

import ai.certifai.util.Conversion;
import ai.certifai.util.Evaluation;
import ai.certifai.util.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advanced For Loop
 *
 * @author codenamewei
 */
public class AdvancedForLoop
{
    static Evaluation eval = new Evaluation(AdvancedForLoop.class);

    public static void main(String[] args)
    {
        InputReader in = new InputReader(AdvancedForLoop.class);

        int numOfUseCase = Integer.parseInt(in.getInputPerLine());

        for(int i = 0; i < numOfUseCase; ++i)
        {
            String line = in.getInputPerLine();

            List<Integer> arrayInput = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            int m = arrayInput.get(0);
            int n = arrayInput.get(1);
            int b = arrayInput.get(2);

            assessArrayValue(m, n, b);
        }

        eval.printResult();
    }

    ////a_m = a_(m - 1) + 2^power + b
    public static void assessArrayValue(int m, int n, int b)
    {
        List<Integer> value = new ArrayList<>();
        int totalValue = 0;
        for(int i = 0; i < m; ++i)
        {
            int currentValue = totalValue + (int) Math.pow(2, n) + b;

            totalValue = currentValue;

            value.add(currentValue);

        }

        String output = Conversion.ListIntegerToString(value);

        eval.evaluatePerLine(output);
    }
}
