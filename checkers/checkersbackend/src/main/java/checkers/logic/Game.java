package checkers.Logic;

import checkers.Model.Board;
import checkers.Model.User;
import checkers.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Game {
    @Autowired
    private UserRepository userRepository;
    private Board board;

    public void newUser(User user){
        userRepository.save(user);
    }

    public void gameStart() {
        //create lobby
        //create new board
        //add cells to board
        //Assign users to board
        //assign board to lobby
    }
}
