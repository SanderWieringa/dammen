package checkers.socketController;

import checkers.model.Board;
import checkers.socketModel.*;
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
    public ValidMessage sendMessage(@Payload final ChatMessage chatMessage) {
        Board board = new Board();
        String number = board.convertToNumbers(chatMessage.getContent());
        System.out.println("number: " + number);
        String[] validCoordinates = board.convertToLetters(board.Algoritme(number));
        ValidMessage validMessage = new ValidMessage();
        validMessage.setSender(chatMessage.getSender());
        validMessage.setType((MessageType.VALIDMOVE));
        validMessage.setContent(validCoordinates);
        return validMessage;
    }

    @MessageMapping("/checkers.newUser")
    @SendTo("/topic/public")
    public CheckersMessage newUser(@Payload final CheckersMessage checkersMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", checkersMessage.getSender());
        checkersMessage.setContent(new Board());
        return checkersMessage;
    }
}
