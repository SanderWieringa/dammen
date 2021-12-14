package checkers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    private Piece[][] board = new Piece[8][8]; // <-- char, not int

    public Board() {
        this.user1 = user1;
        this.user2 = user2;
        for (int r = 0; r < board.length; r++) { // <-- iterate up to 8, not 7
            for (int c = 0; c < board[r].length; c++) {
                if (r < 3 || r >= 5) {

                    if ((r + c) % 2 == 1) { // <-- include column in parity check
                        if (r < 3) {
                            board[r][c] = new Piece(false, Color.BLACK);
                        }
                        if (r >= 5) {
                            board[r][c] = new Piece(false, Color.WHITE);
                        }

                    }
                    else {
                        board[r][c] = new Piece(false, Color.EMPTY);
                    }
                } else {
                    board[r][c] = new Piece(false, Color.EMPTY);

                }
                System.out.println(board[r][c].getColor());
            }
        }
    }

    public String[] Algoritme(String cord)
    {
        String[] results = new String[1];
        //int squareCord = Cord.convert
        String squareCord = "11";

        int half = squareCord.length() % 2 == 0 ? squareCord.length()/2 : squareCord.length()/2 + 1;
        int row = Integer.parseInt(squareCord.substring(0, half)) - 1;
        int column = Integer.parseInt(squareCord.substring(half)) - 1;

        Piece chosen = board[row][column];

        if(chosen.getColor() == Color.BLACK)
        {
            if(chosen.getIsKing())
            {

            }
            else
            {
                if(column == 0)
                {
                    if(board[row+1][column+1].getColor() == Color.EMPTY)
                    {
                        results[0] = (String.valueOf(row + 1) + (column + 1));
                        return results;
                    }
                }
                else if(column == 7)
                {
                    if(board[row+1][column-1].getColor() == Color.EMPTY)
                    {
                        results[0] = (String.valueOf(row + 1) + (column - 1));
                        return results;
                    }
                }
                else
                {
                    if(board[row+1][column+1].getColor() == Color.EMPTY || board[row+1][column-1].getColor() == Color.EMPTY)
                    {

                    }
                }
            }

        }
        else if (chosen.getColor() == Color.WHITE)
        {
            if(chosen.getIsKing())
            {

            }
            else
            {

            }
        }
        else {}

        return results;
    }
}