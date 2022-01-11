package checkers.socketModel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class OriginMessage {
    @Setter
    @Getter
    private MessageType type;
    @Getter
    @Setter
    private CoorCollection content;
    @Setter
    @Getter
    private String sender;

    public OriginMessage(MessageType type, CoorCollection content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }

    public OriginMessage() {

    }
}
