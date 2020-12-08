package ai.certifai.junit5.ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetSetMethodAssertionTestSolution {
    @Test
    void getCoffeeType() {
        GetSetMethodAssertion coffee = new GetSetMethodAssertion("Espresso",9);
        assertEquals("Espresso",coffee.getCoffeeType());
    }

    @Test
    void getPrice() {
        GetSetMethodAssertion coffee = new GetSetMethodAssertion("Latte",11);
        assertEquals(11,coffee.getPrice());

    }

    @Test
    void allCoffeeType() {
        GetSetMethodAssertion espresso = new GetSetMethodAssertion("Espresso",9);
        GetSetMethodAssertion latte = new GetSetMethodAssertion("Latte",11);
        GetSetMethodAssertion mocha = new GetSetMethodAssertion("Mocha",12);

        assertAll(
                ()->assertEquals("Espresso",espresso.getCoffeeType()),
                ()->assertEquals("Latte",latte.getCoffeeType()),
                ()->assertEquals("Mocha",mocha.getCoffeeType())
        );
    }



    @Test
    void exceptionTest() {
        GetSetMethodAssertion coffee = new GetSetMethodAssertion("Latte",11);
        assertThrows(IllegalArgumentException.class,
                ()->coffee.setPrice(-1));
    }

}