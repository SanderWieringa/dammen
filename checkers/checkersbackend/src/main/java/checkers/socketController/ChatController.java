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
    Board board = new Board();
    String[] cordCalculated = new String[0];
    @MessageMapping("/checkers.send")
    @SendTo("/topic/public")
    public ValidMessage sendMessage(@Payload final ChatMessage chatMessage) {
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
    public BoardMessage sendMove(@Payload final OriginMessage originMessage) {
        System.out.println(originMessage.getContent());
        System.out.println("content: " + originMessage.getContent());
        System.out.println("origin: " + originMessage.getContent().getOriginCoor());
        System.out.println("coor: " + originMessage.getContent().getCoor());
        String origin = board.convertToNumbers(originMessage.getContent().getOriginCoor());
        String coor = board.convertToNumbers(originMessage.getContent().getCoor());
        //System.out.println("number: " + number);
//        for (int i = 1; i < cordCalculated.length; i++) {
//            String newNumber = board.convertToNumbers(cordCalculated[i]);
//            cordCalculated[i] = newNumber;
//        }
        Board boardObj = board.ChangeBoard(coor, origin, originMessage.getContent().getCordCalculated());
        BoardMessage boardMessage = new BoardMessage();
//        boardMessage.setContent(board.getBoardObject());
        boardMessage.setContent(boardObj);
        boardMessage.setSender(originMessage.getSender());
        boardMessage.setType((MessageType.BOARDMOVE));
        System.out.println("here");
        return boardMessage;
    }

    @MessageMapping("/checkers.newUser")
    @SendTo("/topic/public")
    public CheckersMessage newUser(@Payload final CheckersMessage checkersMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", checkersMessage.getSender());
        checkersMessage.setContent(board);
        return checkersMessage;
    }
}
