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
package ai.certifai.basic.ex3;

import ai.certifai.basic.ex7.ForLoop;
import ai.certifai.util.InputParser;
import ai.certifai.util.OutputParser;

/**
 * Introduction to one of the most important concept in Java - class
 *
 * @author codenamewei
 */
class PersonalProfile
{
    private String name;

    private int height;
    private int weight;

    public PersonalProfile(String myName, int myHeight, int myWeight)
    {
        name = myName;
        height = myHeight;
        weight = myWeight;

    }
}


public class BluePrint
{
    static OutputParser out;
    static InputParser in;

    public static void main(String[] args)
    {
        in = new InputParser(BluePrint.class);
        out = new OutputParser(BluePrint.class, in);

        PersonalProfile johnProfile = new PersonalProfile("John Doe", 165, 100);

        /*
        out.evaluate("Name: " + johnProfile.getName());
        out.evaluate("Height: " + johnProfile.getHeight());
        out.evaluate("Width: " + johnProfile.getWeight());
        */

        out.printResult();
    }
}
