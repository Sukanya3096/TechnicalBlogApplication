package techicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techicalblog.model.UserModel;
import techicalblog.repository.PostRepository;
import techicalblog.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserModel login(UserModel user) {

        UserModel existingUser = repository.checkUser(user.getUsername(), user.getPassword());
        if(existingUser != null) {
            return existingUser;
        }
        else {
            return null;
        }
    }

    public void registerUser(UserModel newUser) {
        repository.registerUser(newUser);
    }
}
