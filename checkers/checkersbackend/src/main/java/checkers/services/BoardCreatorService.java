package checkers.services;

import checkers.model.Color;
import checkers.model.Piece;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class BoardCreatorService {
    private Piece[][] board = new Piece[8][8]; // <-- char, not int

    public Piece[][] createBoard() {
        board[0][0] = new Piece(false,Color.EMPTY);
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

        return board;
    }


}
