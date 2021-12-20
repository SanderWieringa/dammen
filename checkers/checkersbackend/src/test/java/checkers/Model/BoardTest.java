package checkers.Model;

import checkers.model.Board;
import checkers.model.Piece;
import checkers.model.Color;
import checkers.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp()
    {
        board = new Board();
    }

    @Test
    void testMoveBlack()
    {
        String[] moves = board.Algoritme("34");

        String[] expected = new String[10];
        expected[0] = "lopen";
        expected[1] = "43";
        expected[2] = "45";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testMoveWhite()
    {
        String[] moves = board.Algoritme("65");

        String[] expected = new String[10];
        expected[0] = "lopen";
        expected[1] = "54";
        expected[2] = "56";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testMoveBlackEdgeStart()
    {
        String[] moves = board.Algoritme("38");

        String[] expected = new String[10];
        expected[0] = "lopen";
        expected[1] = "47";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testMoveWhiteEdgeStart()
    {
        String[] moves = board.Algoritme("61");

        String[] expected = new String[10];
        expected[0] = "lopen";
        expected[1] = "52";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testBlackHitWhite()
    {
        Piece[][] editBoard = board.getBoard();
        editBoard[3][2].setColor(Color.WHITE);
        board.setBoard(editBoard);

        String[] moves = board.Algoritme("34");

        String[] expected = new String[10];
        expected[0] = "slaan";
        expected[1] = "52";
        expected[2] = "43";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testWhiteHitBlack()
    {
        Piece[][] editBoard = board.getBoard();
        editBoard[4][3].setColor(Color.BLACK);
        board.setBoard(editBoard);

        String[] moves = board.Algoritme("65");

        String[] expected = new String[10];
        expected[0] = "slaan";
        expected[1] = "43";
        expected[2] = "54";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testWhiteHitTwoBlack()
    {
        Piece[][] editBoard = board.getBoard();
        editBoard[4][3].setColor(Color.BLACK);
        editBoard[4][5].setColor(Color.BLACK);
        board.setBoard(editBoard);

        String[] moves = board.Algoritme("65");

        String[] expected = new String[10];
        expected[0] = "slaan";
        expected[1] = "47";
        expected[2] = "56";
        expected[3] = "43";
        expected[4] = "54";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testBlackHitTwoWhite()
    {
        Piece[][] editBoard = board.getBoard();
        editBoard[3][2].setColor(Color.WHITE);
        editBoard[3][4].setColor(Color.WHITE);
        board.setBoard(editBoard);

        String[] moves = board.Algoritme("34");

        String[] expected = new String[10];
        expected[0] = "slaan";
        expected[1] = "56";
        expected[2] = "45";
        expected[3] = "52";
        expected[4] = "43";
        assertArrayEquals(expected, moves);
    }

    @Test
    void testBlackEdgeNotHitButMove()
    {
        Piece[][] editBoard = board.getBoard();
        editBoard[3][1].setColor(Color.BLACK);
        editBoard[4][0].setColor(Color.WHITE);
        board.setBoard(editBoard);

        String[] moves = board.Algoritme("42");

        String[] expected = new String[10];
        expected[0] = "lopen";
        expected[1] = "53";
        assertArrayEquals(expected, moves);
    }
}
