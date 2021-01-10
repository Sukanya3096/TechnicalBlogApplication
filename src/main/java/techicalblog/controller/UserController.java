package techicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techicalblog.model.PostModel;
import techicalblog.model.UserModel;
import techicalblog.service.PostService;
import techicalblog.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private PostService PostService;

    @Autowired
    private UserService UserService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }
    @RequestMapping(value = "users/registration", method= RequestMethod.POST)
    public String registerUser(UserModel user) {
        return "users/login";
    }
    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(UserModel user) {
        if (UserService.login(user)) {
            return "redirect:/posts";
        } else {
            return "users/login";
        }

    }
    @RequestMapping(value = "users/logout", method= RequestMethod.POST)
    public String logout(Model model) {
        List<PostModel> posts = PostService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
