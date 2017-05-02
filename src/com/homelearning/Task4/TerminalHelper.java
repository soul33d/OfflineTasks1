package com.homelearning.Task4;

import java.util.Scanner;

public class TerminalHelper {
    private Scanner scanner;
    private SquareMatrixHolder squareMatrixHolder;

    public TerminalHelper() {
        scanner = new Scanner(System.in);
    }

    public void execute(){
        squareMatrixHolder = new SquareMatrixHolder(askMatrixSize());
        fillMatrixHolder();
        printMatrix();
        printIsMagicSquare();
    }

    private int askMatrixSize(){
        System.out.println("Please enter square matrix size: ");
        int size = readIntFromInput();
        if (size > 0){
            return size;
        } else {
            System.out.println("You can'n create numbers sequence which size smaller than 1!!!");
            return askMatrixSize();
        }
    }

    private void fillMatrixHolder(){
        for (int i = 0; i < squareMatrixHolder.getSize(); i++) {
            for (int i1 = 0; i1 < squareMatrixHolder.getSize(); i1++) {
                System.out.printf("Please enter integer #%d for #%d row:\n", i1, i);
                squareMatrixHolder.addElement(i, i1, readIntFromInput());
            }
        }
    }

    private void printMatrix() {
        System.out.printf("The matrix you entered:\n%s", squareMatrixHolder);
    }

    private int readIntFromInput(){
        if (scanner.hasNextInt()) return scanner.nextInt();
        else {
            System.out.println("Invalid input, please enter an integer!");
            scanner.next();
            return readIntFromInput();
        }
    }

    private void printIsMagicSquare(){
        if (squareMatrixHolder.isMagicSquare()) System.out.println("is magic square.");
        else System.out.println("is not magic square.");
    }
}