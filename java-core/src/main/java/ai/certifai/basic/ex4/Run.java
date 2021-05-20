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
package ai.certifai.basic.ex4;

/**
 * Basic Java File to test run with terminal / command prompt
 *
 * @author codenamewei
 */
public class Run
{
    public static void main(String[] args)
    {
        if(args.length == 1)
        {
            try
            {
                int value = Integer.parseInt(args[0]);

                if(value % 2 == 0)
                {
                    System.out.println("Even number");
                }
                else
                {
                    System.out.println("Odd number");
                }
            }catch(Exception e)
            {
                System.out.println("Argument parse integer failed: " + e);
            }

        }
        else
        {
            System.out.println("There should be one input");
        }
    }
}
