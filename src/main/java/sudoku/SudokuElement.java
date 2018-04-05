package sudoku;

import java.util.ArrayList;
import java.util.List;

import static sudoku.SudokuRow.EMPTY;

public class SudokuElement {
    private int value;
    private List<Integer> possibleValues = new ArrayList<>();

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public SudokuElement(Integer value) {
        this.value = value;
        if (value == EMPTY) {
            for (int n = 1; n<=9; n++) {
                possibleValues.add(n);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
