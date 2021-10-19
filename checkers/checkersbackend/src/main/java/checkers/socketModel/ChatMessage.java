package checkers.socketModel;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ChatMessage {
    @Getter
    private MessageType type;
    @Getter
    private String conten;
    @Getter
    private String sender;
    @Getter
    private String time;
}
