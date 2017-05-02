package com.homelearning.task3;

public class ProductHolder {
    private String[] products;
    private int[] prices;

    public ProductHolder() {
        products = new String[]{
                "хлеб", "молоко", "сахар", "колбаса", "гречка",
                "чай", "мед", "морковка", "лук", "картошка"
        };
        prices = new int[]{
                500, 1600, 2000, 6000, 4500, 2000, 6000, 500, 300, 700
        };
    }

    public String findProductsByPrice(int price){
        StringBuilder stringBuilder = new StringBuilder("Products for the price of " + price + ": \n");
        return compareProductsByPrice(stringBuilder, price, price);
    }

    public String findProductsByPriceRange(int lowBound, int highBound){
        StringBuilder stringBuilder = new StringBuilder
                (String.format("Products for the price range %d-%d:\n", lowBound, highBound));
        return compareProductsByPrice(stringBuilder, lowBound, highBound);
    }

    private String compareProductsByPrice(StringBuilder stringBuilder, int lowBound, int highBound) {
        int initialSize = stringBuilder.length();
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] >= lowBound && prices[i] <= highBound) stringBuilder.append(products[i]).append(", ");
        }
        if (initialSize < stringBuilder.length()){

            String result = stringBuilder.toString();
            if (result.endsWith(", ")) result = result.substring(0, result.length() - 2) + ".";
            return result;
        } else return "Products for chosen price not found.";
    }

    public String findProductPriceByName(String name){
        for (int i = 0; i < products.length; i++) {
            if (products[i].equals(name)) return String.format("%s %d", name, prices[i]);
        }
        return "Product not found";
    }

    public String findProductByFirstChar(String firstChar){
        StringBuilder stringBuilder = new StringBuilder(String.format("Products that begin with \"%s\": ", firstChar));
        int initialSize = stringBuilder.length();
        for (int i = 0; i < products.length; i++) {
            if (products[i].startsWith(firstChar)) stringBuilder.append(products[i]).append(", ");
        }
        String result = stringBuilder.toString();
        if (initialSize < stringBuilder.length()){
            result = result.substring(0, result.length() - 2);
        } else result = "Products not found";
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            stringBuilder.append(i + 1).append(" ").append(products[i]).append(" ").append(prices[i]).append("\n");
        }
        return stringBuilder.toString();
    }
}