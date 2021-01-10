package techicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techicalblog.model.PostModel;
import techicalblog.service.PostService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService PostService;

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        List<PostModel> posts = PostService.getAllPosts();

        model.addAttribute("posts", posts);

        return "index";
    }
}
