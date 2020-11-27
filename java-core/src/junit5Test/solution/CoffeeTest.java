package solution;

import org.junit.jupiter.api.Test;

/**
 * Demo of Junit5 Test (Test File)
 *
 * @author Boon Khai Yeoh
 */





import static org.junit.jupiter.api.Assertions.*;

    class CoffeeTest {

        @Test
        void getCoffeeType() {
            Coffee coffee = new Coffee("Espresso",9);
            assertEquals("Espresso",coffee.getCoffeeType());
        }

        @Test
        void getPrice() {
            Coffee coffee = new Coffee("Latte",11);
            assertEquals(11,coffee.getPrice());

        }

        @Test
        void allCoffeeType() {
            Coffee espresso = new Coffee("Espresso",9);
            Coffee latte = new Coffee("Latte",11);
            Coffee mocha = new Coffee("Mocha",12);

            assertAll(
                    ()->assertEquals("Espresso",espresso.getCoffeeType()),
                    ()->assertEquals("Latte",latte.getCoffeeType()),
                    ()->assertEquals("Mocha",mocha.getCoffeeType())
            );
        }



        @Test
        void exceptionTest() {
            Coffee coffee = new Coffee("Latte",11);
            assertThrows(IllegalArgumentException.class,
                    ()->coffee.setPrice(-1));
        }
    }

