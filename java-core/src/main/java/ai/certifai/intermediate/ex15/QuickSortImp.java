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
     private int split(List<Integer> array, int beginIndex, int endIndex)
     {
         int pivot = array.get(endIndex);
         int j = beginIndex - 1;
         for(int i = beginIndex; i < endIndex; ++i)
         {
             if(array.get(i) < pivot)
             {
                 ++j;
                 int temp = array.get(i);
                 array.set(i, array.get(j));
                 array.set(j, temp);
             }
         }
         int temp = array.get(j + 1);
         array.set(j + 1, array.get(endIndex));
         array.set(endIndex, temp);
         return j + 1;
     }

    public List<Integer> sort(List<Integer> array, int beginIndex, int endIndex)
    {

        if((array.size() < 2) || (beginIndex >= endIndex))
        {
            return array;
        }

        int pivotIndex = split(array, beginIndex, endIndex);

        sort(array, beginIndex, pivotIndex - 1);
        sort(array, pivotIndex + 1, endIndex);


        return array;
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