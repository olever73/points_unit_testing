package com.example.points_unit_testing.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class Calculator {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(String.format("a=%s, b=%s, cannot divide by zero", a, b));
        }

        return a / b;
    }

//    static String getPerson(Long id) {
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with id " + id + " does not exist");
//    }

}