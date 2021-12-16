package checkers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    @Setter
    @Getter
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

                    } else {
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
        String[] results = new String[10];

        int half = cord.length() % 2 == 0 ? cord.length() / 2 : cord.length() / 2 + 1;
        int row = Integer.parseInt(cord.substring(0, half)) - 1;
        int column = Integer.parseInt(cord.substring(half)) - 1;

        int frontendRow = row + 1;
        int frontendColumn = column + 1;

        Piece chosen = board[row][column];

        if (chosen.getColor() == Color.BLACK)
        {
            if (chosen.getIsKing())
            {

            }
            else
            {
                if (column != 0 && column != 7) //check zijkant
                {
                    if (board[row + 1][column + 1].getColor() != Color.EMPTY && row != 6 || board[row + 1][column - 1].getColor() != Color.EMPTY && row != 6) //check aanliggende stenen
                    {
                        results[0] = "slaan";
                        if (board[row + 1][column + 1].getColor() == Color.WHITE && board[row + 1][column - 1].getColor() == Color.WHITE) //slaan
                            {
                                if(column == 1)
                                {
                                    if(board[row + 2][column + 2].getColor() == Color.EMPTY)
                                    {
                                        results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                        results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                        return results;
                                    }
                                }
                                else if(column == 6)
                                {
                                    if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                                    {
                                        results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                        results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                        return results;
                                    }
                                }
                                else
                                {
                                    if(board[row + 2][column + 2].getColor() == Color.EMPTY && board[row + 2][column - 2].getColor() != Color.EMPTY)
                                    {
                                        results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                        results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                        return results;
                                    }
                                    else if(board[row + 2][column - 2].getColor() == Color.EMPTY && board[row + 2][column + 2].getColor() != Color.EMPTY)
                                    {
                                        results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                        results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                        return results;
                                    }
                                    else if(board[row + 2][column + 2].getColor() == Color.EMPTY && board[row + 2][column - 2].getColor() == Color.EMPTY)
                                    {
                                        results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                        results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                        results[3] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                        results[4] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                        return results;
                                    }
                                }
                            }
                            else if (board[row + 1][column - 1].getColor() == Color.WHITE && column != 1)
                            {
                                if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                            else if (board[row + 1][column + 1].getColor() == Color.WHITE && column != 6)
                            {
                                if(board[row + 2][column + 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                    return results;
                                }
                            }
                            else if(board[row + 1][column + 1].getColor() == Color.EMPTY || board[row + 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                            }
                            if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                            }
                            return results;
                        }
                    }
                    else  //lopen
                    {
                        results[0] = "lopen";
                        if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                        }
                        if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                        }
                        return results;
                    }
                }
                else //aan de zijkant
                {
                    if(column == 0)
                    {
                        if(board[row + 1][column + 1].getColor() != Color.EMPTY && row != 6)
                        {
                            results[0] = "slaan";
                            if(board[row + 2][column + 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                    }
                    else
                    {
                        if(board[row + 1][column - 1].getColor() != Color.EMPTY && row != 6)
                        {
                            results[0] = "slaan";
                            if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                    }
                }
            }

        } else if (chosen.getColor() == Color.WHITE)
        {
            if (chosen.getIsKing())
            {

            }
            else
            {
                if (column != 0 && column != 7) //check zijkant
                {
                    if (board[row - 1][column + 1].getColor() != Color.EMPTY && row != 1 || board[row - 1][column - 1].getColor() != Color.EMPTY && row != 1) //check aanliggende stenen
                    {
                        results[0] = "slaan";
                        if (board[row - 1][column + 1].getColor() == Color.BLACK && board[row - 1][column - 1].getColor() == Color.BLACK) //slaan
                        {
                            if(column == 1)
                            {
                                if(board[row - 2][column + 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    return results;
                                }
                            }
                            else if(column == 6)
                            {
                                if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                            else
                            {
                                if(board[row - 2][column + 2].getColor() == Color.EMPTY && board[row - 2][column - 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    return results;
                                }
                                else if(board[row - 2][column - 2].getColor() == Color.EMPTY && board[row - 2][column + 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                                else if(board[row - 2][column + 2].getColor() == Color.EMPTY && board[row - 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    results[3] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[4] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                        }
                        else if (board[row - 1][column - 1].getColor() == Color.BLACK && column != 1)
                        {
                            if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else if (board[row - 1][column + 1].getColor() == Color.BLACK && column != 6)
                        {
                            if(board[row - 2][column + 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                    }
                    else  //lopen
                    {
                        results[0] = "lopen";
                        if(board[row - 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                        }
                        if(board[row - 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                        }
                        return results;
                    }
                }
                else //aan de zijkant
                {
                    if(column == 0)
                    {
                        if(board[row - 1][column + 1].getColor() != Color.EMPTY && row != 6)
                        {
                            results[0] = "slaan";
                            if(board[row - 2][column + 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row - 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                    }
                    else
                    {
                        if(board[row - 1][column - 1].getColor() != Color.EMPTY && row != 6)
                        {
                            results[0] = "slaan";
                            if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row - 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                    }
                }
            }
        }


        results[0] = "niet valide";
        return results;
    }
}