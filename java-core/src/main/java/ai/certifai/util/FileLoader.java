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
package ai.certifai.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author codenamewei
 */
@Slf4j
public class FileLoader {

    public static File getOutputLoader(Class class_)
    {
        try
        {
            ClassLoader loader = class_.getClassLoader();

            String resourcePath = class_.getName().replace(".", "/");
            String resourceFile = resourcePath + "/" + Config.OUTPUT_FILE;

            return new File(loader.getResource(resourceFile).getFile());
        }
        catch(Exception e)
        {
            log.info("Error when reading input file: " + e.getMessage());
        }
        return null;
    }

    public static File getInputLoader(Class class_)
    {
        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.INPUT_FILE;

        return new File(loader.getResource(resourceFile).getFile());
    }

    public static File getInputLoader(Class class_, String fileName)
    {
        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + fileName;

        return new File(loader.getResource(resourceFile).getFile());
    }
}
