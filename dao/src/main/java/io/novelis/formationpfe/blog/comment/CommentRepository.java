package io.novelis.formationpfe.blog.comment;

import io.novelis.formationpfe.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
