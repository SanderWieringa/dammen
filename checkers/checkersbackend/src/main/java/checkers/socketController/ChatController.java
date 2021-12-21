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
    String[] cordCalculated = new String[0];
    @MessageMapping("/checkers.send")
    @SendTo("/topic/public")
    public ValidMessage sendMessage(@Payload final ChatMessage chatMessage) {
        Board board = new Board();
        String number = board.convertToNumbers(chatMessage.getContent());
        System.out.println("number: " + number);
        cordCalculated = board.convertToLetters(board.Algoritme(number));
        ValidMessage validMessage = new ValidMessage();
        validMessage.setSender(chatMessage.getSender());
        validMessage.setType((MessageType.VALIDMOVE));
        validMessage.setContent(cordCalculated);
        return validMessage;
    }

    @MessageMapping("/checkers.sendMove")
    @SendTo("/topic/public")
    public ValidMessage sendMove(@Payload final ChatMessage chatMessage) {
        System.out.println(chatMessage.getContent());
        Board board = new Board();
        System.out.println("content: " + chatMessage.getContent());
        String number = board.convertToNumbers(chatMessage.getContent());
        System.out.println("number: " + number);
        for (int i = 1; i < cordCalculated.length; i++) {
            String newNumber = board.convertToNumbers(cordCalculated[i]);
            cordCalculated[i] = newNumber;
        }
        board.ChangeBoard(cordCalculated, number);
        return null;
    }

    @MessageMapping("/checkers.newUser")
    @SendTo("/topic/public")
    public CheckersMessage newUser(@Payload final CheckersMessage checkersMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", checkersMessage.getSender());
        checkersMessage.setContent(new Board());
        return checkersMessage;
    }
}
