package com.example.points_unit_testing.utils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static List<Point> points = List.of(

            new Point(30, 35),
            new Point(45, 46),
            new Point(5, 7),
            new Point(23, 7),
            new Point(50, 50)
    );

    public static void main(String[] args) {
        // lan, lon
        Point point = new Point(40, 41);

        var nearestLocation = points.stream()
                .sorted(Comparator.comparing(
                        otherPoint -> getDistance(point, otherPoint)
                ))
                .limit(2)
                .toList();

//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("No locations found"));

        System.out.println(nearestLocation);
    }

    public static Point getNearestLocation(Point me, List<Point> points) {
        // null | Exception

        var maybePoint = getNearestLocations(me, points, 1)
                .stream()
                .findFirst();

        if (maybePoint.isEmpty()) {
            return null;
        }

        return maybePoint.get();
    }

    // code reuse
    public static List<Point> getNearestLocations(Point me, List<Point> points, int results) {
        if (me == null) {
            throw new IllegalArgumentException("Me cannot be null");
        }

        if (points == null) {
            throw new IllegalArgumentException("Points cannot be null");
        }

        if (points.isEmpty()) {
            return new ArrayList<>();
        }

        if (results <= 0) {
            throw new IllegalArgumentException("Results cannot be negative or zero");
        }


        return points.stream()
                .sorted(Comparator.comparing(
                        otherPoint -> getDistance(me, otherPoint)
                ))
                .limit(results)
                .toList();
    }

    static double getDistance(Point me, Point other) {
        return Math.hypot(
                Math.abs(other.x() - me.x()),
                Math.abs(other.y() - me.y())
        );
    }
}

// record = class (ctor + final fields + getters + toString)
record Point(int x, int y) {
}