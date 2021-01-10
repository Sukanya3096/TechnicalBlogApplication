package techicalblog.service;

import org.springframework.stereotype.Service;
import techicalblog.model.UserModel;

@Service
public class UserService {
    public boolean login(UserModel user) {
        if(user.getUsername().equals("validuser")) {
            return true;
        }
        else {
            return false;
        }
    }
}
