package com.greenfoxacademy.reddit.controllers;

import com.greenfoxacademy.reddit.models.Post;
import com.greenfoxacademy.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public List<Post> posts() {
        return postService.listing();
    }

    @PostMapping("newpost")
    public List<Post> addPost(@RequestBody Post post) {
        postService.addPost(post);
        return postService.listing();
    }

    @PutMapping("posts/{id}/upvote")
    public Post upvote(@PathVariable(value = "id") Long id) {
        postService.upvotePost(id);
        return postService.findPost(id);
    }

    @PutMapping("posts/{id}/downvote")
    public Post downvote(@PathVariable(value = "id") Long id) {
        postService.downvotePost(id);
        return postService.findPost(id);
    }
}
