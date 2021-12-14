package checkers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    int row = 8;
    int column = 8;
    private Piece[][] board = new Piece[row][column]; // <-- char, not int
    List<String> letters = new ArrayList<>();

    public void fillList() {
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        letters.add("g");
        letters.add("h");

    }

    public Board() {
        this.user1 = user1;
        this.user2 = user2;
        fillList();

        board[0][0] = new Piece(false, Color.EMPTY, 8, letters.get(0));
        board[0][1] = new Piece(false, Color.BLACK, 8, letters.get(1));
        board[0][2] = new Piece(false, Color.EMPTY, 8, letters.get(2));
        board[0][3] = new Piece(false, Color.BLACK, 8, letters.get(3));
        board[0][4] = new Piece(false, Color.EMPTY, 8, letters.get(4));
        board[0][5] = new Piece(false, Color.BLACK, 8, letters.get(5));
        board[0][6] = new Piece(false, Color.EMPTY, 8, letters.get(6));
        board[0][7] = new Piece(false, Color.BLACK, 8, letters.get(7));

        board[1][0] = new Piece(false, Color.BLACK, 7, letters.get(0));
        board[1][1] = new Piece(false, Color.EMPTY, 7, letters.get(1));
        board[1][2] = new Piece(false, Color.BLACK, 7, letters.get(2));
        board[1][3] = new Piece(false, Color.EMPTY, 7, letters.get(3));
        board[1][4] = new Piece(false, Color.BLACK, 7, letters.get(4));
        board[1][5] = new Piece(false, Color.EMPTY, 7, letters.get(5));
        board[1][6] = new Piece(false, Color.BLACK, 7, letters.get(6));
        board[1][7] = new Piece(false, Color.EMPTY, 7, letters.get(7));

        board[2][0] = new Piece(false, Color.EMPTY, 6, letters.get(0));
        board[2][1] = new Piece(false, Color.BLACK, 6, letters.get(1));
        board[2][2] = new Piece(false, Color.EMPTY, 6, letters.get(2));
        board[2][3] = new Piece(false, Color.BLACK, 6, letters.get(3));
        board[2][4] = new Piece(false, Color.EMPTY, 6, letters.get(4));
        board[2][5] = new Piece(false, Color.BLACK, 6, letters.get(5));
        board[2][6] = new Piece(false, Color.EMPTY, 6, letters.get(6));
        board[2][7] = new Piece(false, Color.BLACK, 6, letters.get(7));

        board[3][0] = new Piece(false, Color.EMPTY, 5, letters.get(0));
        board[3][1] = new Piece(false, Color.EMPTY, 5, letters.get(1));
        board[3][2] = new Piece(false, Color.EMPTY, 5, letters.get(2));
        board[3][3] = new Piece(false, Color.EMPTY, 5, letters.get(3));
        board[3][4] = new Piece(false, Color.EMPTY, 5, letters.get(4));
        board[3][5] = new Piece(false, Color.EMPTY, 5, letters.get(5));
        board[3][6] = new Piece(false, Color.EMPTY, 5, letters.get(6));
        board[3][7] = new Piece(false, Color.EMPTY, 5, letters.get(7));

        board[4][0] = new Piece(false, Color.EMPTY, 4, letters.get(0));
        board[4][1] = new Piece(false, Color.EMPTY, 4, letters.get(1));
        board[4][2] = new Piece(false, Color.EMPTY, 4, letters.get(2));
        board[4][3] = new Piece(false, Color.EMPTY, 4, letters.get(3));
        board[4][4] = new Piece(false, Color.EMPTY, 4, letters.get(4));
        board[4][5] = new Piece(false, Color.EMPTY, 4, letters.get(5));
        board[4][6] = new Piece(false, Color.EMPTY, 4, letters.get(6));
        board[4][7] = new Piece(false, Color.EMPTY, 4, letters.get(7));

        board[5][0] = new Piece(false, Color.WHITE, 3, letters.get(0));
        board[5][1] = new Piece(false, Color.EMPTY, 3, letters.get(1));
        board[5][2] = new Piece(false, Color.WHITE, 3, letters.get(2));
        board[5][3] = new Piece(false, Color.EMPTY, 3, letters.get(3));
        board[5][4] = new Piece(false, Color.WHITE, 3, letters.get(4));
        board[5][5] = new Piece(false, Color.EMPTY, 3, letters.get(5));
        board[5][6] = new Piece(false, Color.WHITE, 3, letters.get(6));
        board[5][7] = new Piece(false, Color.EMPTY, 3, letters.get(7));

        board[6][0] = new Piece(false, Color.EMPTY, 2, letters.get(0));
        board[6][1] = new Piece(false, Color.WHITE, 2, letters.get(1));
        board[6][2] = new Piece(false, Color.EMPTY, 2, letters.get(2));
        board[6][3] = new Piece(false, Color.WHITE, 2, letters.get(3));
        board[6][4] = new Piece(false, Color.EMPTY, 2, letters.get(4));
        board[6][5] = new Piece(false, Color.WHITE, 2, letters.get(5));
        board[6][6] = new Piece(false, Color.EMPTY, 2, letters.get(6));
        board[6][7] = new Piece(false, Color.WHITE, 2, letters.get(7));

        board[7][0] = new Piece(false, Color.WHITE, 1, letters.get(0));
        board[7][1] = new Piece(false, Color.EMPTY, 1, letters.get(1));
        board[7][2] = new Piece(false, Color.WHITE, 1, letters.get(2));
        board[7][3] = new Piece(false, Color.EMPTY, 1, letters.get(3));
        board[7][4] = new Piece(false, Color.WHITE, 1, letters.get(4));
        board[7][5] = new Piece(false, Color.EMPTY, 1, letters.get(5));
        board[7][6] = new Piece(false, Color.WHITE, 1, letters.get(6));
        board[7][7] = new Piece(false, Color.EMPTY, 1, letters.get(7));

        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<column; j++)
            {
                System.out.println("Color: " + board[i][j].getColor() + " Row: " + board[i][j].getRow() + " Column: " + board[i][j].getColumn());
            }
            System.out.println();
        }

//        for (int r = 0; r < board.length; r++) { // <-- iterate up to 8, not 7
//            for (int c = 0; c < board[r].length; c++) {
//                if (r < 3 || r >= 5) {
//
//                    if ((r + c) % 2 == 1) { // <-- include column in parity check
//                        if (r < 3) {
//                            board[r][c] = new Piece(false, Color.BLACK, r + 1, letters.get(c));
//                        }
//                        if (r >= 5) {
//                            board[r][c] = new Piece(false, Color.WHITE, r + 1, letters.get(c));
//                        }
//
//                    }
//                    else {
//                        board[r][c] = new Piece(false, Color.EMPTY, r + 1, letters.get(c));
//                    }
//                } else {
//                    board[r][c] = new Piece(false, Color.EMPTY, r + 1, letters.get(c));
//
//                }
//                System.out.println("Color: " + board[r][c].getColor() + " Row: " + board[r][c].getRow() + " Column: " + board[r][c].getColumn());
//            }
//        }
    }

    public Piece[][] getBoard() {
        return board;
    }
}