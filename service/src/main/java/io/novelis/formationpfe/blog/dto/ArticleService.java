package io.novelis.formationpfe.blog.dto;

import io.novelis.formationpfe.blog.article.ArticleDao;
import io.novelis.formationpfe.blog.entities.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.novelis.formationpfe.blog.dto.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleService {

    private final ArticleDao articleDao;
    private final ArticleMapper articleMapper;

    public ArticleDto filterArticlesByTitle(String title){
        Article article = articleDao.filterByArticleTitle(title);
        if (article != null) {
            return articleMapper.toDto(article);
        }
        return null;
    }

    public List<ArticleDto> getArticles(){



        var articles = articleDao.findAll();
        if (articles.size() != 0) {
            return articleMapper.toDtoList(articles);
        }
        return null;
    }

    public ArticleDto addArticle(ArticleDto articleDto) throws Exception {
        var result = articleDao.save(articleMapper.toEntity(articleDto));
        if (result == null) {
            throw new Exception("Something went wrong ! ");
        }
        return articleMapper.toDto(result);
    }

/*    public void test(){
        User user = new User();
        user.setId(1L);
        user.setFirstName("ib");
        Article article = new Article();
        article.setUser(user);
        article.setId(1L);
        article.setTitle("art");
        article.setComments(new ArrayList<>());

        try{
            System.out.println(article.getId());
            System.out.println(articleDao.getJpaRepository().save(article));;
        }catch (Exception e) {
            System.out.println("hello");
        }

    }*/

}
