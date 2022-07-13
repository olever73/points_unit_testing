package com.example.points_unit_testing.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class CalculatorTest {

    // Given When Then

    // nested inner class???

    @Nested
    @DisplayName("sum()")
    class SumTest {
        @Test
        @DisplayName("should return sum, when parameters are positive")
        public void shouldReturnSumWhenParametersPositiveTest() {
            // given
            int givenA = 2;
            int givenB = 2;

            int expectedResult = 4;

            // when
            int result = Calculator.sum(givenA, givenB);

            // harmcrest
            // Assertions

            // then
            Assertions.assertEquals(expectedResult, result);
        }

        @Test
        @DisplayName("should return sum, when parameters are negative")
        public void shouldReturnSumWhenParametersNegativeTest() {
            int givenA = -2;
            int givenB = -3;

            int expectedResult = -5;

            var result = Calculator.sum(givenA, givenB);

            Assertions.assertEquals(expectedResult, result);
        }
    }

    @Nested
    @DisplayName("subtract()")
    class SubtractTest {

        // kebab-case
        // CapitalCamelCase
        // camelCase
        // sneak_case

        @Test
        @DisplayName("should return diff, when both are positive")
        public void shouldReturnDiffWhenBothPositiveTest() {
            int givenA = 10;
            int givenB = 5;

            int expected = givenA - givenB;

            var result = Calculator.subtract(givenA, givenB);

            Assertions.assertEquals(expected, result);

        }
    }

    @Nested
    @DisplayName("divide()")
    class DivideTest {

        @Test
        @DisplayName("should throw IllegalArgumentException, when divided by zero")
        public void shouldThrowExceptionWhenSecondParameterIsZero() {
            int givenA = 2;
            int givenB = 0;

            var expectedMessage = String.format("a=%s, b=%s, cannot divide by zero", givenA, givenB);

            IllegalArgumentException result = Assertions.assertThrows(
                    IllegalArgumentException.class,
                    () -> Calculator.divide(givenA, givenB)
            );

            Assertions.assertEquals(expectedMessage, result.getMessage());
        }

//        @Test
//        public void abc() {
//
//            HttpStatus expectedStatus = HttpStatus.NOT_FOUND;
//            String message = "... ";
//
//            var exception = Assertions.assertThrows(
//                    ResponseStatusException.class,
//                    () -> Calculator.getPerson(1L)
//            );
//
//            Assertions.assertEquals(expectedStatus, exception.getStatus());
//        }
    }




}