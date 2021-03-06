package checkers.socketModel;

import checkers.model.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class CheckersMessage {
    @Getter
    private MessageType type;
    @Getter
    @Setter
    private Board content;
    @Getter
    private String sender;

}
