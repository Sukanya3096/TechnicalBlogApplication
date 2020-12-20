package techicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import techicalblog.model.PostModel;
import techicalblog.model.UserModel;
import techicalblog.service.PostService;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    private PostService PostService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }
    @RequestMapping("users/registration")
    public String registration() {
        return "users/registration";
    }
    @RequestMapping(value = "users/login", method= RequestMethod.POST)
    public String loginUser(UserModel user) {
        return "redirect:/posts";
    }
    @RequestMapping(value = "users/logout", method= RequestMethod.POST)
    public String logout(Model model) {
        ArrayList<PostModel> posts = PostService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
