package com.example.points_unit_testing.utils;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MainTest {

    @Nested
    @DisplayName("getNearestLocation()")
    class getNearestLocationTest {
        @Test
        @DisplayName("should return the nearest point")
        public void shouldReturnNearestPointTest1() {
            List<Point> points = List.of(

                    new Point(30, 35),
                    new Point(45, 46),
                    new Point(5, 7),
                    new Point(23, 7),
                    new Point(50, 50)
            );

            Point pointMe = new Point(40, 41);

            Point expectedResult = new Point(45, 46);

            Point result = Main.getNearestLocation(pointMe, points);


            Assertions.assertEquals(expectedResult, result);
        }
    }
    @Test
    @DisplayName("should return the nearest point whith negative")
    public void shouldReturnNearestPointTest2() {
        List<Point> points = List.of(

                new Point(30, 35),
                new Point(45, 46),
                new Point(-1, -1),
                new Point(23, 7),
                new Point(50, 50)
        );

        Point pointMe = new Point(0, 0);

        Point expectedResult = new Point(-1, -1);

        Point result = Main.getNearestLocation(pointMe, points);


        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("should return the null,when may be point is empty")
    public void shouldReturnNullNearestPointTest3() {
        List<Point> points = List.of(
        );

        Point pointMe = new Point(0, 0);

        Point expectedResult = null;

        Point result = Main.getNearestLocation(pointMe, points);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("should return the necessary number of closest points")
    public void shouldReturnNearestPointsTest4() {
        List<Point> points = List.of(

                new Point(30, 35),
                new Point(45, 46),
                new Point(-1, -1),
                new Point(2, 7),
                new Point(50, 50)
        );

        Point pointMe = new Point(0, 0);

        List<Point> expectedResult =  List.of(

                new Point(-1, -1),
                new Point(2, 7)
        );
        int numberResult=2;
        List<Point> result = Main.getNearestLocations(pointMe, points,numberResult);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("should return the null,when may be point is empty")
    public void shouldReturnNullNearestPointTest5() {
        List<Point> points = List.of(

        );
        Point pointMe = new Point(0, 0);
        List<Point> expectedResult =  List.of(

        );
        int numberResult=0;
        List<Point> result = Main.getNearestLocations(pointMe, points,numberResult);

        Assertions.assertEquals(expectedResult, result);
    }



    @Test
    @DisplayName("should throw IllegalArgumentException, when me point is null ")
    public void shouldReturnThrowIllegalArgumentExceptionlMePointNullTest66() {
        List<Point> points = List.of(
                new Point(1, 2)
        );
        Point pointMe =null;

        int numberResult=2;

        var expectedMessage = "Me cannot be null";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Main.getNearestLocations(pointMe, points,numberResult)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("should throw IllegalArgumentException, when results  negative or zero")
    public void shouldReturnThrowIllegalArgumentExceptionlNearestPointNegativeTest6() {
        List<Point> points = List.of(
                new Point(1, 2)
        );
        Point pointMe = new Point(0, 0);

        int numberResult=-6;

        var expectedMessage = "Results cannot be negative or zero";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Main.getNearestLocations(pointMe, points,numberResult)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("should throw IllegalArgumentException, when points is null")
    public void shouldReturnThrowIllegalArgumentExceptionlPointsNullTest7() {
        List<Point> points = null;
        Point pointMe = new Point(1, 1);

        int numberResult=1;

        var expectedMessage = "Points cannot be null";

        IllegalArgumentException result = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Main.getNearestLocations(pointMe, points,numberResult)
        );

        Assertions.assertEquals(expectedMessage, result.getMessage());
    }



    @Test
    @DisplayName("should return the distance to the required point")
    public void shouldreturnDistanceRequiredPointTest8() {


        Point pointMe = new Point(42, 9);
        Point other = new Point(49, 0);
     Double expectedResult = 11.40175425099138;

        Double result = Main.getDistance( pointMe,  other);


        Assertions.assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("should return the distance to the required point,when whith negative point")
    public void shouldreturnDistanceRequiredPointTest9() {


        Point pointMe = new Point(-42, -9);
        Point other = new Point(49, -78);
        Double expectedResult = 114.20157617125956;

        Double result = Main.getDistance( pointMe,  other);


        Assertions.assertEquals(expectedResult, result);
    }



}

