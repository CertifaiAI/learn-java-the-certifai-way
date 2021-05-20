/*
 * Copyright (c) 2021 CertifAI Sdn. Bhd.
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
package ai.certifai.intermediate.ex10;

import ai.certifai.util.OutputParser;

import java.io.File;
import java.util.Scanner;

/**
 * Exception Handling
 *
 * @author codenamewei
 */
public class ExceptionHandling
{
    public static void main(String[] args) throws Exception
    {
        OutputParser out = new OutputParser(ExceptionHandling.class);

        out.evaluate(readFile());
        out.evaluate(divideByZero());
        out.evaluate(retrieveObject());

        out.printResult();
    }

    private static String readFile() throws Exception
    {
        String filePathInString = "metadata/sample.txt"; //FILE DID NOT EXIST

        //Rewrite the statement below onwards to catch the exception with try-catch-finally
        File filePath = new File(filePathInString);
        Scanner input = new Scanner(filePath);
        return "";
    }

    private static String divideByZero() throws Exception
    {
        int value = 1000 / 0;

        return "";
    }

    private static String retrieveObject() throws Exception
    {
        String buffer = null;

        buffer.length();

        return "";
    }
}
