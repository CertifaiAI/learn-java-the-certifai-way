package ai.certifai.unitTest.ex2;

/**
 * Demo of Unit Test (Class)
 * Solution : At Bottom of this file
 * @author Boon Khai Yeoh
 */

/**
 * Task 1 : Create a test program file
 *
 *
 * Task 2 : Create a simple test use assertEquals to evaluate the type of coffee
 * by set the value Example : GetSetMethodAssertion coffee = new GetSetMethodAssertion("Espresso",9);
 * and using getCoffeeType() to get the coffee type
 *
 *
 * Task 3 : Create a simple test use assertEquals to evaluate the price of coffee
 * by set the value Example : GetSetMethodAssertion coffee = new GetSetMethodAssertion("Espresso",9);
 * and using getPrice() to get the coffee price
 *
 *
 * Task 4 : Create a simple test use assertAll to evaluate the types of coffee
 * Your type of coffee should be include : Espresso, Latte ,Mocha
 * and using allCoffeeType() to get the type of coffee
 *
 *
 * Task 5 : Create a exception test to evaluate negative price value
 * Type of Exception :  ExceptionIllegalArgumentException
 *
 */

public class GetSetMethodAssertion {

    private String coffeeType;
    private double price;



    public GetSetMethodAssertion(String coffeeType, double price){
        this.coffeeType = coffeeType;
        this.price=price;

    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        this.coffeeType = coffeeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= -1 ){
            throw new IllegalArgumentException("Price must be >=0");
        }
        this.price = price;
    }

}

/** ============================================
 *            Solution for test file
 *  ============================================
 * Task 1 : Create a test program file
 * Put the cursor to the class name "GetSetMethodAssertion"
 * Right click -> Generate -> test
 *
 *
 * Task 2 : Create a simple test use assertEquals to evaluate the type of coffee
 *    @Test
 *     void getCoffeeType() {
 *         GetSetMethodAssertion coffee = new GetSetMethodAssertion("Espresso",9);
 *         assertEquals("Espresso",coffee.getCoffeeType());
 *     }
 *
 *
 * Task 3 : Create a simple test use assertEquals to evaluate the price of coffee
 *     @Test
 *     void getPrice() {
 *         GetSetMethodAssertion coffee = new GetSetMethodAssertion("Latte",11);
 *         assertEquals(11,coffee.getPrice());
 *     }
 *
 *
 * Task 4 : Create a simple test use assertAll to evaluate the types of coffee
 *     @Test
 *     void allCoffeeType() {
 *         GetSetMethodAssertion espresso = new GetSetMethodAssertion("Espresso",9);
 *         GetSetMethodAssertion latte = new GetSetMethodAssertion("Latte",11);
 *         GetSetMethodAssertion mocha = new GetSetMethodAssertion("Mocha",12);
 *
 *         assertAll(
 *                 ()->assertEquals("Espresso",espresso.getCoffeeType()),
 *                 ()->assertEquals("Latte",latte.getCoffeeType()),
 *                 ()->assertEquals("Mocha",mocha.getCoffeeType())
 *         );
 *     }
 *
 *
 * Task 5 : Create a exception test to evaluate negative price value
 *     @Test
 *     void exceptionTest() {
 *         GetSetMethodAssertion coffee = new GetSetMethodAssertion("Latte",11);
 *         assertThrows(IllegalArgumentException.class,
 *                 ()->coffee.setPrice(-1));
 *     }
 */