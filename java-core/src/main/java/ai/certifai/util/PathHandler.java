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