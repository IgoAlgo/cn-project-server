package gist.cnprojectserver.service;

import gist.cnprojectserver.domain.Post;
import gist.cnprojectserver.repository.SpringDataJpaPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    private final SpringDataJpaPostRepository postRepository;

    public PostService(SpringDataJpaPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // 게시글 저장
    public Long store(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    // 전체 게시글 조회
    public List<Post> findPosts() {
        return postRepository.findAll();
    }
}
