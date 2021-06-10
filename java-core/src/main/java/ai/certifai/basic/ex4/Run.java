/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. You should have received a copy of the
 * GNU Affero General Public License along with this program.  If not, see
 *
 *       https://www.gnu.org/licenses/agpl-3.0
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
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
