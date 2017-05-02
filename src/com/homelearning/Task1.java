package com.homelearning;

public class Task1 {

    public static void main(String[] args) {
        String [] product = new String[]{
                "хлеб", "молоко", "сахар", "колбаса", "гречка",
                "чай", "мед", "морковка", "лук", "картошка"
        };
        int[] price = new int[]{
                500, 1600, 2000, 6000, 4500, 2000, 6000, 500, 300, 700
        };
        int totalPrice = 0;
        for (int i = 0; i < product.length; i++) {
            totalPrice += price[i];
            System.out.printf("%d %s %d\n", i + 1, product[i], price[i]);
        }
        System.out.printf("Средняя цена товаров %d", totalPrice/price.length);
    }
}
