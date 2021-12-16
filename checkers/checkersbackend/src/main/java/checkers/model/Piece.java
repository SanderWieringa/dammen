package checkers.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Piece {
    @Setter
    @Getter
    private boolean isKing;
    @Setter
    @Getter
    private Color color;
    @Setter
    @Getter
    private int row;
    @Setter
    @Getter
    private String column;

    public Piece() {

    }

    public Piece(boolean isKing, Color color, int row, String column) {
        this.isKing = isKing;
        this.color = color;
        this.row = row;
        this.column = column;
    }
}
