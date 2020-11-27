package training;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import solution.MathUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    /**
     * Demo of Junit5 Test (Test File)
     *
     * @author Boon Khai Yeoh
     */

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
            solution.MathUtils mathUtils = new solution.MathUtils();
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            /**
            [code here]
             */
        }

        /**
         * Test Method 2 : Using assertAll to compare more value
         *
         * Usage :
         * assertAll is use to compare all the value,
         * evaluate all condition compare to assertEquals
         *
         * Comment the @Disabled to review the difference
         *
         */

        @Test
        @Disabled
        @DisplayName("Multiplication Function Test")
        void mul() {
            solution.MathUtils mathUtils = new solution.MathUtils();
            assertEquals(4, mathUtils.mul(2, 2));
            assertEquals(2, mathUtils.mul(1, 1));
            assertEquals(3, mathUtils.mul(3, 3));
        }


        @Test
        @Disabled
        @DisplayName("Assert ALL Multiplication Function Test")
        void mul1() {
            solution.MathUtils mathUtils = new solution.MathUtils();
            /**
             [code here]
             */

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
        void divide() {
            solution.MathUtils mathUtils = new solution.MathUtils();

            /**
             *
            assertThrows([Code Here], () -> mathUtils.divide(1, 0));
            */
        }

        /**
         * Test Method 4 : ParameterizedTest
         *
         * Usage :
         * Evaluate each element in the ValueSource
         *
         */

        /**
        @ [Code Here]
        @Disabled
        @ValueSource(ints = {3, 4, 5, 6})
        void test(int number) {
            assertEquals(0, number % 3);

        }*/

        /**
         * Test Method 5 : RepeatedTest
         *
         * Usage :
         * Repeat the test base on the number input
         * RepeatedTest(3) << Repeat the test 3 times
         *
         */

        /**
        @ [Code Here]
        @DisplayName("Add Function Test")
        void repeatAdd() {
            solution.MathUtils mathUtils = new MathUtils();
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "The sum expected to be 2");
        }*/

    }