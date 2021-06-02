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
package ai.certifai.basic.ex2;

import ai.certifai.util.OutputParser;

/**
 * A thorough definition about the idea of Package in java
 *
 * @author codenamewei
 */
public class PackagingIntro
{
    static OutputParser out;

    public static void main(String[] args)
    {
        out = new OutputParser(PackagingIntro.class);

        /**
         Enter your code here
         Complete the program by making changes to line 38
         Tips: change the content assign to variable packageName
         **/
        String packageName = null;
        String output = "Package Name = " + packageName;

        out.evaluate(output);

        out.printResult();
    }
}
