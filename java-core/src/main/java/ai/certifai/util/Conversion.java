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
package ai.certifai.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Conversion {

    public static String ListIntegerToString(List<Integer> list)
    {
        if((list == null) || list.isEmpty()) return "";

        StringBuilder strbul  = new StringBuilder();
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext())
        {
            strbul.append(iter.next());
            if(iter.hasNext()){
                strbul.append(" ");
            }
        }
        return strbul.toString();
    }

    public static List<Integer> StringToListInteger(String input)
    {
        return Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<String> StringToListString(String input)
    {
        return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    }
}
