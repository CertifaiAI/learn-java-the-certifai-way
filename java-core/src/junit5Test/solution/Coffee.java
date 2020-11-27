package solution;

/**
 * Demo of Junit5 Test (Class)
 *
 * @author Boon Khai Yeoh
 */

/**
 * Task 1 : Create a test program file
 *
 *
 * Task 2 : Create a simple test use assertEquals to evaluate the type of coffee
 * by set the value Example : Coffee coffee = new Coffee("Espresso",9);
 * and using getCoffeeType() to get the coffee type
 *
 *
 * Task 3 : Create a simple test use assertEquals to evaluate the price of coffee
 * by set the value Example : Coffee coffee = new Coffee("Espresso",9);
 * and using getPrice() to get the coffee price
 *
 *
 * Task 4 : Create a exception test to evaluate negative price value
 * Type of Exception :  ExceptionIllegalArgumentException
 */

public class Coffee {

    private String coffeeType;
    private double price;



    public Coffee(String coffeeType, double price){
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
