package checkers.socketController;

import checkers.socketModel.ChatMessage;
import checkers.socketModel.CheckersMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ChatController {
    @MessageMapping("/checkers.send")
    @SendTo("/topic/public")
    public CheckersMessage sendMessage(@Payload final CheckersMessage checkersMessage) {
        return checkersMessage;
    }

    @MessageMapping("/checkers.newUser")
    @SendTo("/topic/public")
    public CheckersMessage newUser(@Payload final CheckersMessage checkersMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", checkersMessage.getSender());
        return checkersMessage;
    }
}
