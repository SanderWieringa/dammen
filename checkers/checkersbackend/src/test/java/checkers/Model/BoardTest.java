package checkers.Model;

import checkers.model.Board;
import checkers.model.User;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void bord() {
        User user1 = new User();
        User user2 = new User();
        Board board = new Board();
        System.out.println(board);
    }
}
