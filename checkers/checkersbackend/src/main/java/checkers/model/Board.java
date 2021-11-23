package checkers.model;

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
                } else {
                    board[r][c] = null;

                }
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }
}