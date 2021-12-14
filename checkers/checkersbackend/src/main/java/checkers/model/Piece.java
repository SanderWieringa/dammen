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

    public Piece() {

    }

    public Piece(boolean isKing, Color color) {
        this.isKing = isKing;
        this.color = color;
    }

    public boolean getIsKing() {
        return isKing;
    }

    public Color getColor() {
        return color;
    }
}
