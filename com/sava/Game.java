package com.sava;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    Table table;
    public Game() {
        boolean flag = true;
        while (flag) {
            table = new Table();
            System.out.print("Input command: ");
            String[] options = sc.nextLine().split(" ");
            if (options[0].equals("exit")) {
                flag = false;
                break;
            }
            if (options.length != 3) {
                System.out.println("Bad parameters");
                continue;
            }

            if (options[0].equals("start")) {
                String param1 = options[1];
                String param2 = options[2];
                if (param1.equals("user") && param2.equals("user")) {
                    usersBattle();
                } else if (param1.equals("user") && param2.equals("easy")) {
                    userVsAi();
                } else if (param1.equals("easy") && param2.equals("user")) {
                    aiVsUser();
                }
            } else {
                System.out.println("Bad parameters");
            }

        }
    }

    private void usersBattle() {
        table.drawField();
        boolean playerX = true;
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
                if (!table.getWinner().equals("continue")) {
                    System.out.println(table.getWinner());
                    flag = false;
                }
                }
        }
    }

    private void userVsAi() {
        table.drawField();
        boolean flag = true;
        boolean playerX = true;
        while (flag) {
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

    private void aiVsUser() {
        table.drawField();
        boolean flag = true;
        boolean playerX = true;
            while (flag) {
                if (playerX) {
                    Random random = new Random();
                    int cord1 = random.nextInt(3);
                    int cord2 = random.nextInt(3);
                    if (table.isEmpty(cord1 ,cord2)) {
                        Table.field[cord1][cord2] = 'O';
                        System.out.println("Making move level \"easy\"");
                        playerX = false;
                    }
                } else {
                    System.out.print("Enter the coordinates: ");
                    String[] coords = sc.nextLine().split(" ");
                    if (table.checkInput(coords)) {
                        int row = Integer.parseInt(coords[0])-1;
                        int col = Integer.parseInt(coords[1])-1;
                        Table.field[row][col] = 'X';
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
