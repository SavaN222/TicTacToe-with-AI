package com.sava;

import java.util.Scanner;

public class Table {
    private static final int row = 3;
    private static final int col = 3;
    public static int[][] field = new int[row][col];
    private static Scanner sc = new Scanner(System.in);

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

    public boolean checkInput(String cordRow, String cordCol) {
        int cord1 = 0;
        int cord2 = 0;
        try {
            cord1 = Integer.parseInt(cordRow);
            cord2 = Integer.parseInt(cordCol);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }

        if (cord1 < 1 || cord2 < 1 || cord1 > 3 || cord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (field[cord1][cord2] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
        return true;
    }
}
