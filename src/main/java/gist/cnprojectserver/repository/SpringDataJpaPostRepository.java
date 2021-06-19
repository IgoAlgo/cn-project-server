package gist.cnprojectserver.repository;

import gist.cnprojectserver.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaPostRepository extends JpaRepository<Post, Long>, PostRepository {
    @Override
    Optional<Post> findByTitle(String title);
}
