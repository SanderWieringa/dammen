package checkers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class Board {
    private checkers.model.User user1;
    private checkers.model.User user2;
    @Setter
    @Getter
    private Piece[][] board = new Piece[8][8]; // <-- char, not int
    List<String> letters = new ArrayList<>();

//    public Board getBoardObject() {
//        return this;
//    }

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

    public String[] convertToLetters(String[] coordinates) {
        int counter = 0;

        for (int i = 0; i < coordinates.length; i ++) {
            if (coordinates[i] != null) {
                counter ++;
            }
        }

        String[] newArray = new String[counter];

        newArray[0] = coordinates[0];

        for (int i = 1; i < counter; i++) {
            int half = coordinates[i].length() % 2 == 0 ? coordinates[i].length() / 2 : coordinates[i].length() / 2 + 1;
            int row = Integer.parseInt(coordinates[i].substring(0, half));

            int numberCoor = Integer.parseInt(coordinates[i].substring(half));
            String number = String.valueOf(letters.get(numberCoor - 1));
            newArray[i] = row + number;
            System.out.println(newArray[i]);
        }
        return newArray;
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

    public Board ChangeBoard(String coor, String coorOrigin, String actie)
    {
        int half = coorOrigin.length() % 2 == 0 ? coorOrigin.length() / 2 : coorOrigin.length() / 2 + 1;
        int row = Integer.parseInt(coorOrigin.substring(0, half)) - 1;
        int column = Integer.parseInt(coorOrigin.substring(half)) - 1;

        int frontendRow = rowConvert(row + 1);
        int frontendColumn = column + 1;

        Piece moved = board[row][column];
        board[row][column] = new Piece(false, Color.EMPTY);

        if(Objects.equals(actie, "lopen"))
        {
            half = coor.length() % 2 == 0 ? coor.length() / 2 : coor.length() / 2 + 1;
            row = Integer.parseInt(coor.substring(0, half)) - 1;
            column = Integer.parseInt(coor.substring(half)) - 1;

            board[row][column] = moved;
            return this;
        }
        else if(Objects.equals(actie, "slaan"))
        {
            half = coor.length() % 2 == 0 ? coor.length() / 2 : coor.length() / 2 + 1;
            int rowpiece = Integer.parseInt(coor.substring(0, half)) - 1;
            int columnpiece = Integer.parseInt(coor.substring(half)) - 1;

            int rowCoor = row;
            int columnCoor = column;

            if(moved.getColor().equals(Color.WHITE))
            {
                rowCoor--;
            }
            else if(moved.getColor().equals(Color.BLACK))
            {
                rowCoor++;
            }

            if(column > columnpiece)
            {
                columnCoor--;
            }
            else{
                columnCoor++;
            }

            board[rowCoor][columnCoor] = new  Piece(false, Color.EMPTY);

            half = coor.length() % 2 == 0 ? coor.length() / 2 : coor.length() / 2 + 1;
            row = Integer.parseInt(coor.substring(0, half)) - 1;
            column = Integer.parseInt(coor.substring(half)) - 1;

            board[row][column] = moved;

            return this;
        }

        board[row][column] = moved;
        return this;
    }

    public String[] Algoritme(String cord)
    {
        String[] results = new String[10];

        int half = cord.length() % 2 == 0 ? cord.length() / 2 : cord.length() / 2 + 1;
        int row = Integer.parseInt(cord.substring(0, half)) - 1;
        int column = Integer.parseInt(cord.substring(half)) - 1;

        int frontendRow = rowConvert(row + 1);
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
                    if (board[row + 1][column + 1].getColor() == Color.WHITE && row != 6 || board[row + 1][column - 1].getColor() == Color.WHITE && row != 6) //check aanliggende stenen
                    {
                        results[0] = "slaan";
                        if (board[row + 1][column + 1].getColor() == Color.WHITE && board[row + 1][column - 1].getColor() == Color.WHITE) //slaan
                        {
                            if(column == 1)
                            {
                                if(board[row + 2][column + 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    return results;
                                }
                            }
                            else if(column == 6)
                            {
                                if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                            else
                            {
                                if(board[row + 2][column + 2].getColor() == Color.EMPTY && board[row + 2][column - 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    return results;
                                }
                                else if(board[row + 2][column - 2].getColor() == Color.EMPTY && board[row + 2][column + 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                                else if(board[row + 2][column + 2].getColor() == Color.EMPTY && board[row + 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                    results[3] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                    results[4] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                        }
                        else if (board[row + 1][column - 1].getColor() == Color.WHITE && column != 1)
                        {
                            if(board[row + 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else if (board[row + 1][column + 1].getColor() == Color.WHITE && column != 6)
                        {
                            if(board[row + 2][column + 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                        else if(board[row + 1][column + 1].getColor() == Color.EMPTY || board[row + 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                            }
                            if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                            }
                            return results;
                        }
                    }
                    else  //lopen
                    {
                        results[0] = "lopen";
                        if(board[row + 1][column - 1].getColor() == Color.EMPTY && board[row + 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                            results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                        }
                        else if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                        }
                        else if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
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
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn + 1));
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
                                results[1] = (String.valueOf(frontendRow - 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row + 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow - 1) + (frontendColumn - 1));
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
                    if (board[row - 1][column + 1].getColor() == Color.BLACK && row != 1 || board[row - 1][column - 1].getColor() == Color.BLACK && row != 1) //check aanliggende stenen
                    {
                        results[0] = "slaan";
                        if (board[row - 1][column + 1].getColor() == Color.BLACK && board[row - 1][column - 1].getColor() == Color.BLACK) //slaan
                        {
                            if(column == 1)
                            {
                                if(board[row - 2][column + 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                    return results;
                                }
                            }
                            else if(column == 6)
                            {
                                if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                            else
                            {
                                if(board[row - 2][column + 2].getColor() == Color.EMPTY && board[row - 2][column - 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                    return results;
                                }
                                else if(board[row - 2][column - 2].getColor() == Color.EMPTY && board[row - 2][column + 2].getColor() != Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                    return results;
                                }
                                else if(board[row - 2][column + 2].getColor() == Color.EMPTY && board[row - 2][column - 2].getColor() == Color.EMPTY)
                                {
                                    results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                    results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                    results[3] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                    results[4] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                    return results;
                                }
                            }
                        }
                        else if (board[row - 1][column - 1].getColor() == Color.BLACK && column != 1)
                        {
                            if(board[row - 2][column - 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else if (board[row - 1][column + 1].getColor() == Color.BLACK && column != 6)
                        {
                            if(board[row - 2][column + 2].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                    }
                    else  //lopen
                    {
                        results[0] = "lopen";
                        if(board[row - 1][column - 1].getColor() == Color.EMPTY && board[row - 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                            results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                        }
                        else if(board[row - 1][column + 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                        }
                        else if(board[row - 1][column - 1].getColor() == Color.EMPTY)
                        {
                            results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
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
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn + 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row - 1][column + 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn + 1));
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
                                results[1] = (String.valueOf(frontendRow + 2) + (frontendColumn - 2));
                                results[2] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
                                return results;
                            }
                        }
                        else
                        {
                            results[0] = "lopen";
                            if(board[row - 1][column - 1].getColor() == Color.EMPTY)
                            {
                                results[1] = (String.valueOf(frontendRow + 1) + (frontendColumn - 1));
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