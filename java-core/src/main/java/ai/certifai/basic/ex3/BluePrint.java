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
package ai.certifai.basic.ex3;

import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * Introduction to one of the most important concept in Java - class
 *
 * @author codenamewei
 */
class PersonalProfile
{
    public String name;

    public int height;
    public int weight;

    //constructor
    public PersonalProfile(String myName, int myHeight, int myWeight)
    {
        name = myName;
        height = myHeight;
        weight = myWeight;
    }

    /**
     * Enter your code here
     */
}


public class BluePrint
{
    public static void main(String[] args)
    {
        InputParser in = new InputParser(BluePrint.class);
        OutputParser out = new OutputParser(BluePrint.class, in);

        PersonalProfile johnProfile = new PersonalProfile("John Doe", 165, 100);


        /**
         Enter your code here
         Complete the program by uncommenting line 59-61 and making accordingly changes in PersonalProfile class
         **/
        out.evaluate("Name: " + johnProfile.name);
        out.evaluate("Height: " + johnProfile.height);
        out.evaluate("Width: " + johnProfile.weight);

        out.printResult();
    }
}
