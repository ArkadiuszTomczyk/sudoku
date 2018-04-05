package sudoku;

import java.util.Scanner;

public class UserDialogs {
    public static void sayHello () {
        System.out.println("Welcome to sudoku resolver");
    }
    public static Coords getFigure() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter XYV (X:0-8, Y:0-8, V:1-9) or type X to Exit, E for Example or R to Resolve:");
            String s = scanner.nextLine().toUpperCase();
            switch (s) {
                case "X": return new Coords(0,0,0, Coords.EXIT);
                case "E": return new Coords(0,0,0, Coords.EXAMPLE);
                case "R": return new Coords(0,0,0, Coords.RESOLVE);
                default: try {
                    int col = Integer.parseInt(s.substring(0,1));
                    int row = Integer.parseInt(s.substring(1,2));
                    int val = Integer.parseInt(s.substring(2,3));
                    if (s.length()>3||col>8||row>8||val==0) {
                        throw new Exception();
                    }
                    return new Coords(col, row, val, Coords.FIGURE);
                } catch (Exception e ) {
                    System.out.println("Wrong command, try again!");
                }

            }

        }
    }
}
