package sudoku;

import java.util.ArrayList;
import java.util.List;


import static sudoku.SudokuRow.EMPTY;

public class SudokuBoard {
    private List<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for(int n=0; n<9; n++) {
            rows.add(new SudokuRow());
        }
    }
    public void setValue(int x, int y, int value) {
        rows.get(y).getCols().get(x).setValue(value);
    }

    public Integer getValue(int x, int y) {
        return rows.get(y).getCols().get(x).getValue();
    }
    @Override
    public String toString() {
        String s = "|===|===|===|===|===|===|===|===|===|";
        for (SudokuRow row: rows) {
            s+= "\n|";
            for (SudokuElement element: row.getCols()) {
                if (element.getValue()==EMPTY) {
                    s+= "   ";
                } else {
                    s+= " " + element.getValue()+" ";
                }
                s+= "|";
            }
            s+= "\n|===|===|===|===|===|===|===|===|===|";
        }
        return s;
    }
    public SudokuElement getElement(int x, int y) {
        return rows.get(y).getCols().get(x);
    }
}
