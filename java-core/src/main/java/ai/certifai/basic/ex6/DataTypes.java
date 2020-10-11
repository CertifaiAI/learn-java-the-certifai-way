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
package ai.certifai.basic.ex6;

import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * Data Types
 *
 * @author codenamewei
 */
public class DataTypes
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(DataTypes.class);
        out = new OutputParser(DataTypes.class, in);

        /**
         Enter your code here to pass the program
         Tips: out.evaluate({content}) has to be used to pass the program
         **/

        out.printResult();
    }
}
