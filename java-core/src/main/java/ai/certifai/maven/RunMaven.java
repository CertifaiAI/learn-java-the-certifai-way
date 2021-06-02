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
