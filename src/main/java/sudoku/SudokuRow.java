package sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    public static final Integer EMPTY = -1;
    private List<SudokuElement> cols = new ArrayList<>();

    public SudokuRow() {
        for(int n=0; n<9; n++) {
            cols.add(new SudokuElement(EMPTY));
        }

    }

    public List<SudokuElement> getCols() {
        return cols;
    }
}
