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
