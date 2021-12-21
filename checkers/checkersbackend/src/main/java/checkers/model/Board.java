package checkers.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    @Setter
    @Getter
    private Piece[][] board = new Piece[8][8]; // <-- char, not int
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

    public String convertToNumbers(String oldCoor) {
        fillList();
        int half = oldCoor.length() % 2 == 0 ? oldCoor.length() / 2 : oldCoor.length() / 2 + 1;
        int row = Integer.parseInt(oldCoor.substring(0, half));
        String numberCoor = oldCoor.substring(half);
        String number = String.valueOf(letters.indexOf(numberCoor) + 1);
        row = rowConvert(row);
        return row + number;
    }

    public int rowConvert(int row)
    {
        if(row == 1)
        {
            row = 8;
        }
        else if(row == 2)
        {
            row = 7;
        }
        else if(row == 3)
        {
            row = 6;
        }
        else if(row == 4)
        {
            row = 5;
        }
        else if(row == 5)
        {
            row = 4;
        }
        else if(row == 6)
        {
            row = 3;
        }
        else if(row == 7)
        {
            row = 2;
        }
        else if(row == 8)
        {
            row = 1;
        }
        return row;
    }

    public void convertToLetters() {

    }

    public Board() {
        this.user1 = user1;
        this.user2 = user2;

        board[0][0] = new Piece(false, Color.EMPTY);
        board[0][1] = new Piece(false, Color.BLACK);
        board[0][2] = new Piece(false, Color.EMPTY);
        board[0][3] = new Piece(false, Color.BLACK);
        board[0][4] = new Piece(false, Color.EMPTY);
        board[0][5] = new Piece(false, Color.BLACK);
        board[0][6] = new Piece(false, Color.EMPTY);
        board[0][7] = new Piece(false, Color.BLACK);

        board[1][0] = new Piece(false, Color.BLACK);
        board[1][1] = new Piece(false, Color.EMPTY);
        board[1][2] = new Piece(false, Color.BLACK);
        board[1][3] = new Piece(false, Color.EMPTY);
        board[1][4] = new Piece(false, Color.BLACK);
        board[1][5] = new Piece(false, Color.EMPTY);
        board[1][6] = new Piece(false, Color.BLACK);
        board[1][7] = new Piece(false, Color.EMPTY);

        board[2][0] = new Piece(false, Color.EMPTY);
        board[2][1] = new Piece(false, Color.BLACK);
        board[2][2] = new Piece(false, Color.EMPTY);
        board[2][3] = new Piece(false, Color.BLACK);
        board[2][4] = new Piece(false, Color.EMPTY);
        board[2][5] = new Piece(false, Color.BLACK);
        board[2][6] = new Piece(false, Color.EMPTY);
        board[2][7] = new Piece(false, Color.BLACK);

        board[3][0] = new Piece(false, Color.EMPTY);
        board[3][1] = new Piece(false, Color.EMPTY);
        board[3][2] = new Piece(false, Color.EMPTY);
        board[3][3] = new Piece(false, Color.EMPTY);
        board[3][4] = new Piece(false, Color.EMPTY);
        board[3][5] = new Piece(false, Color.EMPTY);
        board[3][6] = new Piece(false, Color.EMPTY);
        board[3][7] = new Piece(false, Color.EMPTY);

        board[4][0] = new Piece(false, Color.EMPTY);
        board[4][1] = new Piece(false, Color.EMPTY);
        board[4][2] = new Piece(false, Color.EMPTY);
        board[4][3] = new Piece(false, Color.EMPTY);
        board[4][4] = new Piece(false, Color.EMPTY);
        board[4][5] = new Piece(false, Color.EMPTY);
        board[4][6] = new Piece(false, Color.EMPTY);
        board[4][7] = new Piece(false, Color.EMPTY);

        board[5][0] = new Piece(false, Color.WHITE);
        board[5][1] = new Piece(false, Color.EMPTY);
        board[5][2] = new Piece(false, Color.WHITE);
        board[5][3] = new Piece(false, Color.EMPTY);
        board[5][4] = new Piece(false, Color.WHITE);
        board[5][5] = new Piece(false, Color.EMPTY);
        board[5][6] = new Piece(false, Color.WHITE);
        board[5][7] = new Piece(false, Color.EMPTY);

        board[6][0] = new Piece(false, Color.EMPTY);
        board[6][1] = new Piece(false, Color.WHITE);
        board[6][2] = new Piece(false, Color.EMPTY);
        board[6][3] = new Piece(false, Color.WHITE);
        board[6][4] = new Piece(false, Color.EMPTY);
        board[6][5] = new Piece(false, Color.WHITE);
        board[6][6] = new Piece(false, Color.EMPTY);
        board[6][7] = new Piece(false, Color.WHITE);

        board[7][0] = new Piece(false, Color.WHITE);
        board[7][1] = new Piece(false, Color.EMPTY);
        board[7][2] = new Piece(false, Color.WHITE);
        board[7][3] = new Piece(false, Color.EMPTY);
        board[7][4] = new Piece(false, Color.WHITE);
        board[7][5] = new Piece(false, Color.EMPTY);
        board[7][6] = new Piece(false, Color.WHITE);
        board[7][7] = new Piece(false, Color.EMPTY);
    }

    public void ChangeBoard(String[] cordCalculated, String cord)
    {
        int half = cord.length() % 2 == 0 ? cord.length() / 2 : cord.length() / 2 + 1;
        int row = Integer.parseInt(cord.substring(0, half)) - 1;
        int column = Integer.parseInt(cord.substring(half)) - 1;

        Piece moved = board[row][column];
        board[row][column] = new Piece(false, Color.EMPTY);

        if(cordCalculated[0].equals("lopen"))
        {
            half = cordCalculated[1].length() % 2 == 0 ? cordCalculated[1].length() / 2 : cordCalculated[1].length() / 2 + 1;
            row = Integer.parseInt(cordCalculated[1].substring(0, half)) - 1;
            column = Integer.parseInt(cordCalculated[1].substring(half)) - 1;

            board[row][column] = moved;
            return;
        }
        else if(cordCalculated[0].equals("slaan"))
        {
            half = cordCalculated[1].length() % 2 == 0 ? cordCalculated[1].length() / 2 : cordCalculated[1].length() / 2 + 1;
            row = Integer.parseInt(cordCalculated[1].substring(0, half)) - 1;
            column = Integer.parseInt(cordCalculated[1].substring(half)) - 1;

            board[row][column] = moved;

            half = cordCalculated[2].length() % 2 == 0 ? cordCalculated[1].length() / 2 : cordCalculated[1].length() / 2 + 1;
            row = Integer.parseInt(cordCalculated[2].substring(0, half)) - 1;
            column = Integer.parseInt(cordCalculated[2].substring(half)) - 1;

            board[row][column] = new Piece(false, Color.EMPTY);
            return;
        }

        board[row][column] = moved;
    }

    public String[] Algoritme(String cord)
    {
        String[] results = new String[10];

        int half = cord.length() % 2 == 0 ? cord.length() / 2 : cord.length() / 2 + 1;
        int row = Integer.parseInt(cord.substring(0, half)) - 1;
        int column = Integer.parseInt(cord.substring(half)) - 1;

        int frontendRow = rowConvert(row) + 1;
        int frontendColumn = column + 1;

        Piece chosen = board[row][column];

        if (chosen.getColor() == Color.WHITE)
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
                        if (board[row + 1][column + 1].getColor() == Color.BLACK && board[row + 1][column - 1].getColor() == Color.BLACK) //slaan
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
                            else if (board[row + 1][column - 1].getColor() == Color.BLACK && column != 1)
                            {
                                if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                            else if (board[row + 1][column + 1].getColor() == Color.BLACK && column != 6)
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

        } else if (chosen.getColor() == Color.BLACK)
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
                        if (board[row - 1][column + 1].getColor() == Color.WHITE && board[row - 1][column - 1].getColor() == Color.WHITE) //slaan
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
                        else if (board[row - 1][column - 1].getColor() == Color.WHITE && column != 1)
                        {
                            if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else if (board[row - 1][column + 1].getColor() == Color.WHITE && column != 6)
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