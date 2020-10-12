/*
 Copyright (c) 2020 CertifAI Sdn. Bhd.
 *
 This program and the accompanying materials are made available under the
 terms of the Apache License, Version 2.0 which is available at
 https://www.apache.org/licenses/LICENSE-2.0.
 *
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 License for the specific language governing permissions and limitations
 under the License.
 *
 SPDX-License-Identifier: Apache-2.0
 */
package ai.certifai.intermediate.ex15;

import ai.certifai.util.Conversion;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

import java.util.List;

class QuickSort
{
    /**
     Modify your code in this class
     Do the accordingly changes to reach the successful run of the code
     **/

    public List<Integer> sort(List<Integer> array, int beginIndex, int endIndex)
    {

        return null;
    }
}

/**
 Quick Sort
 *
 @author codenamewei
 */
public class QuickSortImp
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(QuickSortImp.class);
        out = new OutputParser(QuickSortImp.class, in);

        int totalUseCases = in.getTotalUseCases();

        for(int i = 0; i < totalUseCases; ++i)
        {
            String line = in.getStringInput();

            List<Integer> arrayInput = Conversion.StringToListInteger(line);

            List<Integer> arrayOutput = new QuickSort().sort(arrayInput, 0, arrayInput.size() - 1);

            out.evaluate(Conversion.ListIntegerToString(arrayOutput));

        }
        out.printResult();

    }
}