package com.sava;

import java.util.Scanner;

public class Table {
    private static final int row = 3;
    private static final int col = 3;
    public static int[][] field = new int[row][col];
    private static Scanner sc = new Scanner(System.in);
    private static final int xWin = 264;
    private static final int oWin = 237;

    public Table() {
        System.out.print("Enter the cells: ");
        char[] cells = sc.nextLine().toCharArray();
        int num = 0;
        while (num < 9) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (cells[num] == '_') {
                        cells[num] = ' ';
                    }
                    field[i][j] = cells[num];
                    num++;
                }
            }
        }
        drawField();
    }

    public void drawField() {
        System.out.println("---------");
        for (int i = 0; i < row; i++) {
            System.out.printf("| %c %c %c |\n", field[i][0], field[i][1], field[i][2]);
        }
        System.out.println("---------");
    }

    public boolean checkInput(String[] coords) {
        int cord1 = 0;
        int cord2 = 0;
        try {
            cord1 = Integer.parseInt(coords[0]);
            cord2 = Integer.parseInt(coords[1]);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (cord1 < 1 || cord2 < 1 || cord1 > 3 || cord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (field[cord1 - 1][cord2 - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }

    private String horizontal() {
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += field[i][j];
            }
            if (result == xWin) {
                return "X wins";
            } else if (result == oWin) {
                return "O wins";
            } else {
                result = 0;
            }
        }
        return "Draw";
    }

    private String vertical() {
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += field[j][i];
            }
            if (result == xWin) {
                return "X wins";
            } else if (result == oWin) {
                return "O wins";
            } else {
                result = 0;
            }
        }
        return "Draw";
    }

    public String leftDiagonal() {
        int result = 0;
        for (int i = 0; i < row; i++) {
            result += field[i][i];
        }

        if (result == xWin) {
            return "X wins";
        } else if (result == oWin) {
            return "O wins";
        }
        return "Draw";
    }
}
