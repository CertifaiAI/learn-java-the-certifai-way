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
package ai.certifai.intermediate.ex11;

import ai.certifai.util.FileLoader;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * While Loop
 *
 * @author codenamewei
 */
public class WhileLoop
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args) throws Exception
    {
        in = new InputParser(WhileLoop.class);
        out = new OutputParser(WhileLoop.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String inputFileName = in.getStringInput();

            File inputFilePath = new FileLoader().getInputLoader(WhileLoop.class, inputFileName);

            readFile(inputFilePath);
        }

        out.printResult();
    }

    private static void readFile(File inputFile) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        /**
         Modify your code in this function
         Do the accordingly changes to this function to reach the successful run of the code
         Tips: out.evaluate({content}) has to be used for the program to be success
         **/
    }

}
