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
package ai.certifai.basic.ex7;

import ai.certifai.util.Evaluation;
import ai.certifai.util.InputReader;

/**
 * For Loop
 *
 * @author codenamewei
 */
public class ForLoop
{
    static Evaluation eval = new Evaluation(ForLoop.class);

    public static void main(String[] args)
    {
        InputReader in = new InputReader(ForLoop.class);

        int numOfUseCase = Integer.parseInt(in.getInputPerLine());

        /*
        for(int j = 0; j < numOfUseCase; ++j)
        {
            int linesPerUseCase = Integer.parseInt(in.getInputPerLine());

            for(int i = 0; i < linesPerUseCase; ++i)
            {
                eval.evaluatePerLine(in.getInputPerLine());
            }
        }*/

        eval.printResult();
    }

}
