package com.sava;

import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    Table table = new Table();

    public Game() {
        boolean playerX = table.playerTurn();
        boolean flag = true;

        while (flag) {
            System.out.print("Enter the coordinates: ");
            String[] coords = sc.nextLine().split(" ");
            if (table.checkInput(coords)) {
                int row = Integer.parseInt(coords[0])-1;
                int col = Integer.parseInt(coords[1])-1;
                if (playerX) {
                    Table.field[row][col] = 'X';
                    playerX = false;
                } else {
                    Table.field[row][col] = 'O';
                    playerX = true;
                }
                table.drawField();
                System.out.println(table.getWinner());
                flag = false;
            }

        }
    }
}
