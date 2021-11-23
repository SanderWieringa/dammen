package checkers.socketModel;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CheckersMessage {
    @Getter
    private MessageType type;
    @Getter
    private String content;
    @Getter
    private String sender;
}
