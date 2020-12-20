package techicalblog.service;

import org.springframework.stereotype.Service;
import techicalblog.model.PostModel;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    public ArrayList<PostModel> getAllPosts() {
        ArrayList<PostModel> posts = new ArrayList<>();

        PostModel post1 = new PostModel();
        post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());

        PostModel post2 = new PostModel();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());

        PostModel post3 = new PostModel();
        post3.setTitle("Post 3");
        post3.setBody("Post Body 3");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }

    public ArrayList<PostModel> getOnePost() {
        ArrayList<PostModel> posts = new ArrayList<>();

        PostModel post1 = new PostModel();
        post1.setTitle("This is your Post");
        post1.setBody("This is your Post. It has some valid content");
        post1.setDate(new Date());
        posts.add(post1);

        return posts;

    }

}
