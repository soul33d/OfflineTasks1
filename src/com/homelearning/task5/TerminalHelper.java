package com.homelearning.task5;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TerminalHelper {
    private Scanner scanner;
    private Pattern pattern;

    public TerminalHelper() {
        scanner = new Scanner(System.in);
        pattern = Pattern.compile("[\\W]*");
    }

    public void execute(){
        System.out.println(removeExtra(askMessage()));
        scanner.close();
    }

    private String removeExtra(String msg){
        char previous;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) stringBuilder.append(chars[i]);
            else {
                previous = stringBuilder.charAt(stringBuilder.length() - 1);
                if (previous != chars[i] && isSignToRemove(chars[i])) {
                    stringBuilder.append(chars[i]);
                } else if (!isSignToRemove(chars[i])) stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    private boolean isSignToRemove(char c) {
        return pattern.matcher(String.valueOf(c)).matches();
    }

    private String askMessage(){
        System.out.println("Please enter your message:");
        if (scanner.hasNext()){
            return scanner.next();
        } else  return "";
    }
}
