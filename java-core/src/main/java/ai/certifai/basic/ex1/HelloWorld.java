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
package ai.certifai.basic.ex1;

import ai.certifai.util.OutputParser;


/**
 * Iconic Hello World Quickstart
 *
 * @author codenamewei
 */
class HelloWorld
{
    static OutputParser out;

    public static void main(String[] args)
    {
        out = new OutputParser(HelloWorld.class);

        /**
        Enter your code here
        Complete the program by making changes to line 38
        Tips: change the content assign to variable firstString
         **/
        String firstString = null;

        out.evaluate(firstString);

        out.printResult();
    }
}