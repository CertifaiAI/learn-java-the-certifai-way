package ai.certifai.junit5.ex1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
class BasicMethodAssertionTest {

    /**
     * Test Method 1 : Using assertEquals to compare two value.
     *
     * Usage :
     * If both value are equal , the test will pass
     *
     */

    @Test
    @DisplayName("Add Function Test")
    void add() {
        BasicMethodAssertion mathUtils = new BasicMethodAssertion();
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected,actual,"The sum expected to be 2");
    }

    /**
     * Test Method 2 : Using assertAll to compare more value
     *
     * Usage :
     * assertAll is use to compare all the value,
     * evaluate all condition compare to assertEquals
     *
     * Comment the @Disabled to review the difference
     */

    @Test
    @Disabled
    @DisplayName("Multiplication Function Test")
    void mul(){
        BasicMethodAssertion mathUtils = new BasicMethodAssertion();
        assertEquals(4,mathUtils.mul(2,2));
        assertEquals(2,mathUtils.mul(1,1));
        assertEquals(3,mathUtils.mul(3,3));
    }


    @Test
    @Disabled
    @DisplayName("Assert ALL Multiplication Function Test")
    void mul1(){
        BasicMethodAssertion mathUtils = new BasicMethodAssertion();
        assertAll(
                ()->assertEquals(4,mathUtils.mul(2,2)),
                ()->assertEquals(2,mathUtils.mul(1,1)),
                ()->assertEquals(3,mathUtils.mul(3,3))
        );
    }

    /**
     * Test Method 3 : assertThrows
     *
     * Usage :
     * Use to evaluate the Exception
     * assertThrows(Type of Exception,condition)
     * when condition is meet the type of Exception,
     * the test is pass
     *
     */

    @Test
    @DisplayName("Divide Function Test")
    void divide(){
        BasicMethodAssertion mathUtils = new BasicMethodAssertion();
        assertThrows(ArithmeticException.class,() -> mathUtils.divide(1,0));

    }

    /**
     * Test Method 4 : ParameterizedTest
     *
     * Usage :
     * Evaluate each element in the ValueSource
     *
     */

    @ParameterizedTest
    @ValueSource(ints ={3,4,5,6})
    void test(int number){
        assertEquals(0,number%3);

    }


    /**
     * Test Method 5 : RepeatedTest
     *
     * Usage :
     * Repeat the test base on the number input
     * RepeatedTest(3) << Repeat the test 3 times
     *
     */

    @RepeatedTest(3)
    @DisplayName("Add Function Test")
    void repeatAdd() {
        BasicMethodAssertion mathUtils = new BasicMethodAssertion();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The sum expected to be 2");
    }


    /**
     * Task 1 : Evaluate difference of two value by create minus (subtraction) test case using assertEquals
     *
     *
     * Task 2 : Compare more subtraction equation by using assertAll
     */

}