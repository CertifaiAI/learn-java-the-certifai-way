/*
 * #
 * #    Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 * #
 * #    This program is part of OSRFramework. You can redistribute it and/or modify
 * #    it under the terms of the GNU Affero General Public License as published by
 * #    the Free Software Foundation, either version 3 of the License, or
 * #    (at your option) any later version.
 * #
 * #    This program is distributed in the hope that it will be useful,
 * #    but WITHOUT ANY WARRANTY; without even the implied warranty of
 * #    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * #    GNU Affero General Public License for more details.
 * #
 * #    You should have received a copy of the GNU Affero General Public License
 * #    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #
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
