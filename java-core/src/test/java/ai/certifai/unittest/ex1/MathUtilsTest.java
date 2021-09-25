package ai.certifai.unittest.ex1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demo of Unit Test (Test File)
 * Test Naming Method : methodName_expectedBehavior_stateUnderTest
 * @author Boon Khai Yeoh
 */

class MathUtilsTest {

    /**
     * Test Method 1 : Using assertEquals to compare two value.
     *
     * Usage :
     * If both value are equal , the test will pass
     *
     */

    @Test
    @DisplayName("additionTest_True_ifCorrectSumOfTwoVariable")
    void additionTest() {
        MathUtils mathUtils = new MathUtils();
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
     * observe the difference between assertEquals and assertAll method
     * Comment the @Disabled to review the difference
     */

    @Test
    @Disabled
    @DisplayName("equalsMultiplicationTest_True_ifCorrectProductOfTwoVariable")
    void equalsMultiplicationTest(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(4,mathUtils.mul(2,2));
        assertEquals(2,mathUtils.mul(1,1));
        assertEquals(3,mathUtils.mul(3,3));
    }


    @Test
    @Disabled
    @DisplayName("allMultiplicationTest_True_ifCorrectProductOfTwoVariable")
    void allMultiplicationTest(){
        MathUtils mathUtils = new MathUtils();
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
    @DisplayName("divideTest_ExceptionThrown_ifInvalidAnswer")
    void divideTest(){
        MathUtils mathUtils = new MathUtils();
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
    @DisplayName("allElementTest_True_ifZeroRemainder")
    @ValueSource(ints ={3,4,5,6})
    void allElementTest(int number){
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
    @DisplayName("repeatAddTest_True_ifCorrectSumOfTwoVariable")
    void repeatAddTest() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The sum expected to be 2");
    }


    /**
     * Create the test function
     * Task 1 : Evaluate difference of two value by create minus (subtraction) test case using assertEquals
     *
     *
     * Task 2 : Compare more subtraction equation by using assertAll
     */

}