package article;

import com.querydsl.jpa.impl.JPAQuery;
import entities.Article;
import entities.QArticle;
import io.novelis.common.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ArticleDao extends AbstractDao<Article,ArticleRepository> {

    private ArticleRepository articleRepository;
    @Override
    public ArticleRepository getJpaRepository() {
        return articleRepository;
    }

    public List<Article> getUserArticles(Long userId){
        JPAQuery<Article> query = getJPAQueryFactory().selectFrom(QArticle.article);
        Long id = getJpaRepository().findAll().parallelStream().map(Article::getUser)
                .filter(user -> Objects.equals(user.id, userId))
                .findAny().get().id;

        if (userId != null) {
            query.where(QArticle.article.user.id.eq(id));
        }
        return query.fetch();
    }

    public List<Article> findArticlesForUsersOlderThan(int restrictedAge){

        JPAQuery<Article> query = getJPAQueryFactory().selectFrom(QArticle.article);
        query.where(QArticle.article.user.Age.goe(restrictedAge));

        return query.fetch();
    }

    public Article filterByArticleTitle(String title){

        JPAQuery<Article> query = getJPAQueryFactory().selectFrom(QArticle.article);
        if (!title.isBlank()) {
            query.where(QArticle.article.title.like("%"+title+"%"));
        }
        return (Article) query.fetch();
    }

}
