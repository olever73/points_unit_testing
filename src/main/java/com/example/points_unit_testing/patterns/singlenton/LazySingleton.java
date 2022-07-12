package com.example.points_unit_testing.patterns.singlenton;

import lombok.SneakyThrows;

public class LazySingleton {
    public static String NAME = "Driver name";
    public static String VERSION = "1.46";
    private static volatile LazySingleton instance;

    @SneakyThrows
    private LazySingleton() {
        System.out.println("INSTANCE");
        Thread.sleep(60_000);
    }



    public /*synchronized*/ static LazySingleton getInstance() {

        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {

                    instance = new LazySingleton();
                    // Happens Before

                    // 1. instance = null
                    // 2. instance = garbage
                    // 3. LazySingleton()
                    // 4. instance = LazySingleton()
                }
                // Double If Check pattern
                // Double-Check Locking
            }
        }

        return instance;
    }
    // thread 2
    // thread 1

}