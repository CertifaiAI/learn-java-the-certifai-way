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
package ai.certifai.basic.ex2;

import ai.certifai.util.Evaluation;

/**
 * A thorough definition about the idea of Package in java
 *
 * @author codenamewei
 */
public class PackagingIntro
{
    static Evaluation eval = new Evaluation(PackagingIntro.class);

    public static void main(String[] args)
    {
        String packageName = null; //Enter your code here
        String output = "Package Name = " + packageName;

        eval.evaluatePerLine(output);

        eval.printResult();
    }
}