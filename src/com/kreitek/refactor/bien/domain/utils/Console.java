package com.kreitek.refactor.bien.domain.utils;

import com.kreitek.refactor.bien.interfaces.StringPrinter;

public class Console implements StringPrinter {
    private static volatile Console instance = null;

    private Console() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance method to create");
        }
    }

    public static Console getInstance() {
        if (instance == null) {
            synchronized (Console.class) {
                if (instance == null) {
                    instance = new Console();
                }
            }
        }

        return instance;
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
