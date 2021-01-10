package techicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techicalblog.model.PostModel;
import techicalblog.repository.PostRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<PostModel> getAllPosts() {
        ArrayList<PostModel> posts = new ArrayList<>();
        return repository.getAllPosts();
    }

    public PostModel getOnePost() {
        ArrayList<PostModel> posts = new ArrayList<>();
        return repository.getLatestPost();

    }

    public void createPost(PostModel newPost) {
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post: "+newPost);
    }

    public PostModel getPost(Integer postId) {
        return repository.getPost(postId);
    }

    public void updatePost(PostModel updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postId) {
        repository.deletePost(postId);
    }

}
