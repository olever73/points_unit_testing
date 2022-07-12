package com.example.points_unit_testing.patterns.singlenton;

import lombok.SneakyThrows;

public class EagerSingleton {

    public static String NAME = "Driver name";
    public static String VERSION = "1.46";
    private static EagerSingleton instance = new EagerSingleton();

    @SneakyThrows
    private EagerSingleton() {
        Thread.sleep(60_000);
    }

    public static EagerSingleton getInstance() {
        return instance;
    }

}