package com.homelearning;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result;
        System.out.println("Please enter your word to check is it a palindrome:");
        if (scanner.hasNext()){
            result = scanner.next();
        } else return;
        String temp = result.toLowerCase();
        StringBuilder sb = new StringBuilder(temp);
        if (temp.equals(sb.reverse().toString())) System.out.println("\"" + result + "\" is a palindrome.");
        else System.out.println("\"" + result + "\" is not a palindrome.");
    }
}