package gist.cnprojectserver.controller;

import gist.cnprojectserver.domain.Post;
import gist.cnprojectserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {


    @Autowired
    private final PostService postService;

    // Dependency Injection
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok().body(postService.findPosts());
    }
}
