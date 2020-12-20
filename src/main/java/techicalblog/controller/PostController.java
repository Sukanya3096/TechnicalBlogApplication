package techicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techicalblog.model.PostModel;
import techicalblog.service.PostService;

import java.util.ArrayList;
@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        ArrayList<PostModel> posts = postService.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";
    }
}
