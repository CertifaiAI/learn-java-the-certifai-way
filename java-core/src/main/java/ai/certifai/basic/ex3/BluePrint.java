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

import ai.certifai.util.Evaluation;

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
    static Evaluation eval = new Evaluation(BluePrint.class, false);

    public static void main(String[] args)
    {
        PersonalProfile johnProfile = new PersonalProfile("John Doe", 165, 100);

        /*
        eval.evaluatePerLine("Name: " + johnProfile.getName());
        eval.evaluatePerLine("Height: " + johnProfile.getHeight());
        eval.evaluatePerLine("Width: " + johnProfile.getWeight());
        */

        eval.printResult();
    }
}
