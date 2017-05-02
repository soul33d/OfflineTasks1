package com.homelearning.task3;

import java.util.Scanner;

public class TerminalHelper {
    private static final int BY_PRICE_KEY = 1;
    private static final int BY_PRICE_RANGE_KEY = 2;
    private static final int BY_NAME_KEY = 3;
    private static final int BY_FIRST_CHAR_KEY = 4;

    private ProductHolder productHolder;
    private Scanner scanner = new Scanner(System.in);

    public TerminalHelper() {
        productHolder = new ProductHolder();
    }

    public void execute(){
        printMenu();
        checkAndExecuteAction(askAction());
    }

    private void printMenu(){
        System.out.println("Products available on the market: ");
        System.out.println(productHolder);
        System.out.printf("To find products by price press %d\n", BY_PRICE_KEY);
        System.out.printf("To find products by price range press %d\n", BY_PRICE_RANGE_KEY);
        System.out.printf("To find products and price by name press %d\n", BY_NAME_KEY);
        System.out.printf("To find products by first char press %d\n", BY_FIRST_CHAR_KEY);
    }

    private int askAction(){
        System.out.println("Please enter an integer for an action.");
        int selectedAction;
        if (scanner.hasNextInt()){
            selectedAction = scanner.nextInt();
        } else {
            System.out.println("Invalid input, press correct key for an action!");
            scanner.next();
            return askAction();
        }
        return selectedAction;
    }

    private void checkAndExecuteAction(int action){
        switch (action){
            case BY_PRICE_KEY:
                System.out.println(productHolder.findProductsByPrice(readIntegerFromInput()));
                break;
            case BY_PRICE_RANGE_KEY:
                System.out.println
                        (productHolder.findProductsByPriceRange(readIntegerFromInput(), readIntegerFromInput()));
                break;
            case BY_NAME_KEY:
                System.out.println(productHolder.findProductPriceByName(readNameFromInput()));
                break;
            case BY_FIRST_CHAR_KEY:
                System.out.println(productHolder.findProductByFirstChar(readCharFromInput()));
                break;
            default:
                System.out.println("The are is no action for entered number!");
                checkAndExecuteAction(askAction());
        }


    }

    private int readIntegerFromInput() {
        System.out.println("Please enter your price");
        if (scanner.hasNextInt()) return scanner.nextInt();
        else {
            System.out.println("Invalid input, please enter an integer!");
            scanner.next();
            return readIntegerFromInput();
        }
    }

    private String readNameFromInput() {
        System.out.println("Please enter the name to find product");
        if (scanner.hasNext()) return scanner.next();
        else {
            System.out.println("Invalid input, please enter the product name!");
            return readNameFromInput();
        }
    }

    private String readCharFromInput() {
        System.out.println("Please enter the first char to find products");
        String result;
        String invalidMsg = "Invalid input, please enter first char for the products name to find!";
        if (scanner.hasNext()){
            result = scanner.next();
            if (result.length() == 1) return result;
            else {
                System.out.println(invalidMsg);
                return readCharFromInput();
            }
        } else {
            System.out.println(invalidMsg);
            scanner.next();
            return readCharFromInput();
        }
    }
}