package checkers.socketModel;

import checkers.model.Board;
import lombok.Builder;
import lombok.Getter;

@Builder
public class LobbyMessage {
    @Getter
    private MessageType type;
    @Getter
    private String sender;

}
