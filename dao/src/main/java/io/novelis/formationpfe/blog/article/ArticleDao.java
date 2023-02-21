package io.novelis.formationpfe.blog.article;

import com.querydsl.jpa.impl.JPAQuery;
import io.novelis.formationpfe.blog.entities.Article;
import io.novelis.formationpfe.blog.AbstractDao;
import io.novelis.formationpfe.blog.entities.QArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ArticleDao extends AbstractDao<Article,ArticleRepository> {
    private final ArticleRepository articleRepository;

    public ArticleDao(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleRepository getJpaRepository() {
        return this.articleRepository;
    }

    @Override
    public Page<Article> createEntityPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        Pageable pageable = PageRequest.of(pageNo - 1 , pageSize);
        return this.articleRepository.findAll(pageable);
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
