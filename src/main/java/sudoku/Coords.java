package sudoku;

public class Coords {
    public final static String FIGURE = "FIGURE";
    public final static String RESOLVE = "RESOLVE";
    public final static String EXIT = "EXIT";
    public final static String EXAMPLE = "EXAMPLE";

    private int col;
    private int row;
    private int value;
    private String command;

    public Coords(int col, int row, int value, String command) {
        this.col = col;
        this.row = row;
        this.value = value;
        this.command = command;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }

    public String getCommand() {
        return command;
    }
}
