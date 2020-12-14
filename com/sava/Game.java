package com.sava;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    Table table = new Table();

    public Game() {
        boolean playerX = true;
        boolean flag = true;

        while (flag) {
            if (playerX) {
                System.out.print("Enter the coordinates: ");
                String[] coords = sc.nextLine().split(" ");
                if (table.checkInput(coords)) {
                    int row = Integer.parseInt(coords[0])-1;
                    int col = Integer.parseInt(coords[1])-1;
                    Table.field[row][col] = 'X';
                    playerX = false;
                }
            } else {
                Random random = new Random();
                int cord1 = random.nextInt(3);
                int cord2 = random.nextInt(3);
                if (table.isEmpty(cord1 ,cord2)) {
                    Table.field[cord1][cord2] = 'O';
                    System.out.println("Making move level \"easy\"");
                    playerX = true;
                }
            }
            table.drawField();
            if (!table.getWinner().equals("continue")) {
                System.out.println(table.getWinner());
                flag = false;
            }
        }
    }
}
