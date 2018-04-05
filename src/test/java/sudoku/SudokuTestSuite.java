package sudoku;

import org.junit.Test;

public class SudokuTestSuite {
    private SudokuBoard prepareTestData() {
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

        return board;
    }
    @Test
    public void testResolveSudoku() {
        SudokuGame game = new SudokuGame();
        game.setSudokuBoard(prepareTestData());
        game.resolveSudoku();

        System.out.println(game.getSudokuBoard());

    }
}
