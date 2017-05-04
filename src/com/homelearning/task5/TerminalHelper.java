package com.homelearning.task5;

import java.util.Scanner;

public class TerminalHelper {
    private Scanner scanner;

    public TerminalHelper() {
        scanner = new Scanner(System.in);
    }

    public void execute(){
        System.out.println(removeExtra(askMessage()));
    }

    private String removeExtra(String msg){
        char previous;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                previous = chars[0];
                stringBuilder.append(chars[i]);
            } else previous = chars[i-1];
            if (previous != chars[i]){
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    private String askMessage(){
        System.out.println("Please enter your message:");
        if (scanner.hasNext()){
            return scanner.next();
        } else  return "";
    }
}
