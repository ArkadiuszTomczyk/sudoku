package sudoku;

import java.util.List;

import static sudoku.SudokuRow.EMPTY;

public class SudokuGame {
    private SudokuBoard sudokuBoard;
    private int getSquareNumber(int n) {
        return n/3;
    }

    public boolean resolveSudoku() {
        boolean modified = true;
        while (modified) {
            modified = false;
            for (int row=0; row<9; row++) {
                for (int col=0; col<9; col++) {
                    if (sudokuBoard.getValue(col, row)==EMPTY) {
                        //column
                        for (int k=0; k<9;k++) {
                            Integer v=sudokuBoard.getValue(col, k);
                            if (v!=EMPTY) {
                                sudokuBoard.getElement(col, row).getPossibleValues().remove(v);
                            }
                        }
                        //row
                        for (int k=0; k<9;k++) {
                            Integer v=sudokuBoard.getValue(k, row);
                            if (v!=EMPTY) {
                                sudokuBoard.getElement(col, row).getPossibleValues().remove(v);
                            }
                        }
                        // square
                        List<Integer> possibles = sudokuBoard.getElement(col,row).getPossibleValues();
                        for (int dX = 0; dX<3; dX++) {
                            for (int dY = 0; dY<3; dY++) {
                                Integer v = sudokuBoard.getValue(getSquareNumber(col)*3+dX, getSquareNumber(row)*3+dY);
                                if (v!=EMPTY) {
                                    possibles.remove(v);
                                }
                            }
                        }
                    }
                }
            }
            // checking possible solutions
            for (int col=0; col<9; col++) {
                for (int row=0; row<9; row++) {
                    if (sudokuBoard.getValue(col, row)== EMPTY) {
                        if (sudokuBoard.getElement(col, row).getPossibleValues().size()==1) {
                            sudokuBoard.setValue(col, row, sudokuBoard.getElement(col, row).getPossibleValues().get(0));
                            modified= true;
                        }
                    }
                }
            }
            System.out.println(sudokuBoard);
            System.out.println();
        }
        return true;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean play() {
        sudokuBoard = new SudokuBoard();
        UserDialogs.sayHello();
        while (true) {
            System.out.println(sudokuBoard);
            Coords coords = UserDialogs.getFigure();
            switch (coords.getCommand()) {
                case Coords.EXIT: return false;
                case Coords.FIGURE: sudokuBoard.setValue(coords.getCol(), coords.getRow(), coords.getValue());
                    break;
                case Coords.RESOLVE: return resolveSudoku();
                case Coords.EXAMPLE: fillExampleData();
            }
        }
    }

    private void fillExampleData() {
        SudokuBoard board = new SudokuBoard();
        board.setValue(1,1,7);
        board.setValue(3,0,2);
        board.setValue(8,0,3);
        board.setValue(4,1,9);
        board.setValue(6,1,2);
        board.setValue(1,2,6);
        board.setValue(2,2,1);
        board.setValue(3,2,5);
        board.setValue(4,2,8);
        board.setValue(7,2,4);
        board.setValue(8,2,9);
        board.setValue(0,3,8);
        board.setValue(5,3,4);
        board.setValue(8,3,1);
        board.setValue(0,5,7);
        board.setValue(3,5,8);
        board.setValue(8,5,4);
        board.setValue(0,6,5);
        board.setValue(1,6,9);
        board.setValue(4,6,7);
        board.setValue(5,6,8);
        board.setValue(6,6,3);
        board.setValue(7,6,1);
        board.setValue(2,7,4);
        board.setValue(4,7,3);
        board.setValue(7,7,5);
        board.setValue(0,8,6);
        board.setValue(5,8,1);
        sudokuBoard = board;
    }
}


