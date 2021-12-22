package checkers.socketModel;

import checkers.model.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class BoardMessage {
    @Getter
    @Setter
    private MessageType type;
    @Getter
    @Setter
    private Board content;
    @Getter
    @Setter
    private String sender;

    public BoardMessage(MessageType type, Board content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public BoardMessage() {

    }
}
