package io.novelis.formationpfe.blog.comment;

import com.querydsl.jpa.impl.JPAQuery;
import io.novelis.formationpfe.blog.entities.Comment;
import io.novelis.formationpfe.blog.AbstractDao;
import io.novelis.formationpfe.blog.entities.QComment;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CommentDao extends AbstractDao<Comment,CommentRepository> {

    private CommentRepository commentRepository;
    @Override
    public CommentRepository getJpaRepository() {
        return commentRepository;
    }

    @Override
    public Page<Comment> createEntityPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }


    public List<Comment> filterCommentsByDate(String minDateToFixLater){
        var maxDate = LocalDate.now();
        JPAQuery<Comment> query= getJPAQueryFactory().selectFrom(QComment.comment);
        if (minDateToFixLater != null){
           query.where(QComment.comment.publishingDate.between(LocalDate.parse(minDateToFixLater),maxDate));
        }
        return query.fetch();
    }



}
