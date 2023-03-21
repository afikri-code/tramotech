package de.tramotech.demo.prametrizedtest;

import java.util.UUID;

public class App {
    public static void main(String[] args) {
        for(int i = 0; i< 3;i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
