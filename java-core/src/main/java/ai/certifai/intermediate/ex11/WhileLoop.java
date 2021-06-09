/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
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

            out.evaluate(getTotalNumberOfLines(inputFilePath));
        }

        out.printResult();
    }

    private static int getTotalNumberOfLines(File inputFile) throws Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        /**
         Modify your code in this function
         Change the return value to get the success of the program
         **/
        return 0;
    }

}
