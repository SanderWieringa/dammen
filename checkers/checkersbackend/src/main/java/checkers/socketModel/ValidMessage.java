package checkers.socketModel;

import checkers.model.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class ValidMessage {
    @Setter
    @Getter
    private MessageType type;
    @Getter
    @Setter
    private String[] content;
    @Setter
    @Getter
    private String sender;

    public ValidMessage(MessageType type, String[] content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public ValidMessage() {

    }
}
