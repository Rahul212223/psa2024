package com.crm.controller;

import com.crm.entity.Comments;
import com.crm.entity.Post;
import com.crm.repository.CommentsRepository;
import com.crm.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private PostRepository postRepository;
    private CommentsRepository  commentsRepository;

    public CommentController(PostRepository postRepository, CommentsRepository commentsRepository) {
        this.postRepository = postRepository;
        this.commentsRepository = commentsRepository;
    }
    //http://localhost:8080/api/v1/comments?postId=1
    @PostMapping
    public String createComment(
            @RequestBody Comments comments,
            @RequestParam long postId
            )
    {
        System.out.println("1000");
        System.out.println("2000");
        Post post = postRepository.findById(postId).get();
        comments.setPost(post);
        commentsRepository.save(comments);
        return "Comment added successfully!";

    }
}
