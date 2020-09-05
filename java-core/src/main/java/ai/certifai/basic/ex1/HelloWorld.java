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
package ai.certifai.basic.ex1;

import ai.certifai.util.Evaluation;

public class HelloWorld
{
    static Evaluation eval = new Evaluation(HelloWorld.class);

    public static void main(String[] args)
    {
        String firstString = null; //Enter your code here

        eval.evaluatePerLine(firstString);

        eval.printResult();
    }
}