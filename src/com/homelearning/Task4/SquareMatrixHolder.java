package com.homelearning.Task4;

import java.util.Arrays;

public class SquareMatrixHolder {
    private int[][] squareMatrix;

    public SquareMatrixHolder(int size) {
        squareMatrix = new int[size][size];
    }

    public boolean isMagicSquare(){
        boolean firstSum = true;
        int previousSum = 0;
        int diagonalSum = 0;
        int reverseDiagonalSum = 0;
        for (int i = 0; i < squareMatrix.length; i++) {
            int horizontalSum = 0;
            int verticalSum = 0;
            for (int i1 = 0; i1 < squareMatrix.length; i1++) {
                horizontalSum += squareMatrix[i][i1];
                verticalSum += squareMatrix[i1][i];
                if (firstSum){
                    diagonalSum += squareMatrix[i1][i1];
                    reverseDiagonalSum += squareMatrix[i1][squareMatrix.length - 1 - i1];
                }
            }

            if (firstSum) {
                firstSum = false;
                previousSum = horizontalSum;
            } else if (previousSum != horizontalSum) return false;
            else if (previousSum != verticalSum) return false;
            else if (previousSum != diagonalSum) return false;
            else if (previousSum != reverseDiagonalSum) return false;
        }
        return true;
    }

    public void addElement(int row, int index, int value){
        squareMatrix[row][index] = value;
    }

    public int getSize(){
        return squareMatrix.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(Arrays.toString(squareMatrix[i])).append("\n");
        }
        return stringBuilder.toString();
    }
}