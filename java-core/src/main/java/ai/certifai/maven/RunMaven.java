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
package ai.certifai.maven;

import ai.certifai.util.PathHandler;

/**
 * Maven
 *
 * @author codenamewei
 */
public class RunMaven {
    public static void main(String[]args)
    {
        /*
        //TODO: Change this into your own image path
        String sourceImagePath = "C:\\Users\\chiaw\\Desktop\\images\\chip\\70.jpg";

        //Check image validity
        if(PathHandler.isFileValid(sourceImagePath) == false)
        {
            System.out.println("Program abort. ");
            return;
        }

        //Read in image
        Mat opencvMat = imread(sourceImagePath);
        int w = opencvMat.cols();
        int h = opencvMat.rows();
        int depth = opencvMat.depth();

        if(depth == 1)
        {
            System.out.println("Image already is grayscale. Program abort");
            return;
        }

        //Create output Mat to store grayscale image
        Mat outputImage = new Mat();

        //Convert the image to grayscale
        cvtColor(opencvMat, outputImage, COLOR_RGB2GRAY);

        //Save output image as file
        String outputPath = PathHandler.getPathToFile(sourceImagePath) + "_grayscale.png";
        imwrite(outputPath, outputImage);
        System.out.println("The image is successfully to Grayscale");


        imshow("Color Image", opencvMat);
        imshow("Grayscale Image", outputImage);

        //Press "Esc" to close window
        if (waitKey(0) == 27) destroyAllWindows();
        */
    }
}
