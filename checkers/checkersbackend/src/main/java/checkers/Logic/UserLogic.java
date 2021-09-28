package checkers.Logic;

import checkers.Model.User;
import checkers.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLogic {

    @Autowired
    private UserRepository repository;

    public User getUser(int id) {
        return repository.findById(id).orElseThrow(() -> null);
    }

    public User getUserByName(String name){ return repository.findByUsername(name); }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(int id){
        repository.deleteById(id);
    }
}
