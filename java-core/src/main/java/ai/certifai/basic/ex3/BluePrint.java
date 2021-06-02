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
