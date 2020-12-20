package techicalblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import techicalblog.model.PostModel;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPosts(Model model) {
        ArrayList<PostModel> posts = new ArrayList<>();
        PostModel post1 = new PostModel();
        post1.setTitle("Post Title 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());

        PostModel post2 = new PostModel();
        post2.setTitle("Post Title 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        posts.add(post1);
        posts.add(post2);

        model.addAttribute("posts", posts);

        return "index";
    }
}
