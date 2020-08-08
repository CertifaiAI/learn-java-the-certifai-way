package ai.certifai.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;

public class InputReader
{
    private BufferedReader br;

    public InputReader(Class class_)
    {
        ClassLoader loader = class_.getClassLoader();

        String resourcePath = class_.getName().replace(".", "/");
        String resourceFile = resourcePath + "/" + Config.INPUT_FILE;

        File file = new File(Objects. requireNonNull(loader.getResource(resourceFile)).getFile());

        try
        {
            br = new BufferedReader(new FileReader(file));
        }
        catch(Exception e)
        {
            System.out.println("Error occurs during declare BufferedReader: " + e);
        }
    }

    public String getInputPerLine()
    {
        try {
            String input;

            if((input = br.readLine()) != null)
            {
                return input;
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println("Input error: " + e);
        }
        return null;

    }

}
