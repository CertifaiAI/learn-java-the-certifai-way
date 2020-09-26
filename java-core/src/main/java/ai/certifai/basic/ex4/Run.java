package ai.certifai.basic.ex4;

/**
 * Basic Java File to test run with terminal / command prompt
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
