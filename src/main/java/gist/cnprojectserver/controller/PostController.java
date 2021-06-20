package gist.cnprojectserver.controller;

import gist.cnprojectserver.domain.ErrorMessage;
import gist.cnprojectserver.domain.Post;
import gist.cnprojectserver.domain.PostDto;
import gist.cnprojectserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@Controller
@CrossOrigin("*")
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

    @PostMapping("/posts")
    public ResponseEntity<Object> addpost(@RequestBody PostDto postDto) {
        return ResponseEntity.created(URI.create("/posts/" + postService.storePost(postDto))).build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        return postService.findPostById(id)
                .map(post -> {
                    post.setTitle(postDto.getTitle());
                    post.setContent(postDto.getContent());
                    postService.updatePost(post);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() ->
                        ResponseEntity.badRequest().body(
                                new ErrorMessage(HttpStatus.BAD_REQUEST.value(), "해당 ID의 게시글을 찾을 수 없습니다.")
                        )
                );
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}
