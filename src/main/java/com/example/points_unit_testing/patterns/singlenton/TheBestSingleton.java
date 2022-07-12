package com.example.points_unit_testing.patterns.singlenton;

import lombok.SneakyThrows;

public class TheBestSingleton {

    public static final String NAME = "Application Name";
    public static final String VERSION = "2.15.241";

    private static class SingletonHelper { // Java Classloader
        private static final TheBestSingleton INSTANCE = new TheBestSingleton();
    }

    @SneakyThrows
    private TheBestSingleton() {
        Thread.sleep(60_000);
    }

    public static TheBestSingleton getInstance() {
        // thread 2
        // thread 1
        return SingletonHelper.INSTANCE;
    }

}