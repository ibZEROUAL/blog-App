package comment;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import entities.Comment;
import entities.QComment;
import io.novelis.common.AbstractDao;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class CommentDao extends AbstractDao<Comment,CommentRepository> {

    private CommentRepository commentRepository;
    @Override
    public CommentRepository getJpaRepository() {
        return commentRepository;
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
