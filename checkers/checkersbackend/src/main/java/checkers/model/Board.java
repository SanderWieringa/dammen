package checkers.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    private char[][] board = new char[8][8]; // <-- char, not int

    public char[][] bord() {


        for (int r = 0; r < board.length; r++) { // <-- iterate up to 8, not 7
            for (int c = 0; c < board[r].length; c++) {
                if (r < 3 || r >= 5) {

                    if ((r + c) % 2 == 1) { // <-- include column in parity check
                        if (r < 3) {
                            board[r][c] = '*';
                        }
                        if (r >= 5) {
                            board[r][c] = '@';
                        }
                    }
                } else {
                    board[r][c] = '0';

                }
            }
        }
        return board;
    }
}