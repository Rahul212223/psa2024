package com.crm.controller;


import com.crm.entity.Post;
import com.crm.repository.CommentsRepository;
import com.crm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    
    private PostRepository  postRepository;
    private CommentsRepository  commentsRepository;

    public PostController(PostRepository postRepository, CommentsRepository commentsRepository) {
        this.postRepository = postRepository;
        this.commentsRepository = commentsRepository;
    }
    @PostMapping
    public String createPost(
            @RequestBody Post post
    ){
        postRepository.save(post);
        return "saved";
    }

    @DeleteMapping
    public String deletePost(

    ){
        postRepository.deleteById(1L);
        return "deleted";
    }
}
