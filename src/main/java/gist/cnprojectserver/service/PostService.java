package gist.cnprojectserver.service;

import gist.cnprojectserver.domain.Post;
import gist.cnprojectserver.domain.PostDto;
import gist.cnprojectserver.repository.SpringDataJpaPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private final SpringDataJpaPostRepository postRepository;

    public PostService(SpringDataJpaPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 저장
    @Transactional
    public String storePost(PostDto postDto) {
        Post post = postRepository.save(
                Post.builder()
                        .title(postDto.getTitle())
                        .content(postDto.getContent())
                        .build());
        return String.valueOf(post.getId());
    }

    @Transactional
    public String updatePost(Post post) {
        postRepository.save(post);
        return String.valueOf(post.getId());
    }

    @Transactional
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    /*
    public ResponseEntity<Object> updateTemplate(@RequestBody TemplateRequestDto templateRequestDto, @PathVariable Long id) {
        return templateService.getTemplateById(id)
                .map(template -> {
                    template.setTitle(templateRequestDto.getTitle());
                    template.setContent(templateRequestDto.getContent());
                    templateService.updateTemplate(template);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.badRequest().body(
                        new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ErrorCase.INVALID_FIELD_ERROR)));
    }
*/
    // 전체 게시글 조회
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    // 해당 id의 게시글 조회
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

}
