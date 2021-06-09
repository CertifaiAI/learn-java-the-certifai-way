/*
 * Copyright (c) 2020-2021 CertifAI Sdn. Bhd.
 *
 * This program is part of OSRFramework. You can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package ai.certifai.util;

import java.io.File;

public class PathHandler {

    public static String getPathToFile(String pathName) {
        String[] subString = pathName.split("/");
        String fullPathName = subString[subString.length - 1];

        String[] separator = fullPathName.split("\\.");

        int fileEndIndex = fullPathName.length() - separator[(separator.length - 1)].length() - 1;
        String fileName = fullPathName.substring(0, fileEndIndex);

        Integer pathLength = pathName.length() - fullPathName.length();
        String pathToSave = pathName.substring(0, pathLength);

        fileName = fileName.replace(".", "_"); //replace any possible "." with "_"
        fileName = fileName.replace(" ", ""); //replace any possible " " with ""

        String pathFirstHalf = pathToSave + fileName;

        return pathFirstHalf;
    }

    public static Boolean isFileValid(String pathName) {

        try {
            File fileImagePath = new File(pathName);

            if (fileImagePath.exists() == false) {
                System.out.println("File did not exist");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error happened when reading in image.");
            e.printStackTrace();
            return false;
        }

        return true;
    }
}