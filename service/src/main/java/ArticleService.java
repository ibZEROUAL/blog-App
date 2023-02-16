import article.ArticleDao;
import dto.ArticleDto;
import entities.Article;
import mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleService {

    private final ArticleDao articleDao;
    private final ArticleMapper articleMapper;

    public ArticleService(ArticleDao articleDao, ArticleMapper articleMapper) {
        this.articleDao = articleDao;
        this.articleMapper = articleMapper;
    }

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

}
