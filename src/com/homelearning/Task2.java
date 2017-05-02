package com.homelearning;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] a = new int[size];
        int[] b = new int[size];
        double[] c = new double[size];
        fillArray(random, a, 10, 20);
        fillArray(random, b, 30, 40);
        for (int i = 0; i < size; i++) {
            c[i] = Math.sqrt(a[i]*a[i] + b[i]*b[i]);
        }
        for (int i = 0; i < size; i++) {
            System.out.printf("#%d a:%d  b:%d  c:%f\n", i, a[i], b[i], c[i]);
        }
    }

    private static void fillArray(Random random, int[] a, int floor, int ceil) {
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(ceil - floor) + floor;
        }
    }
}
