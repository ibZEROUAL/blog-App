package io.novelis.formationpfe.blog.dto;

import io.novelis.formationpfe.blog.article.ArticleDao;
import io.novelis.formationpfe.blog.entities.Article;
import lombok.extern.slf4j.Slf4j;
import io.novelis.formationpfe.blog.dto.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    public ArticleDto addArticle(ArticleDto articleDto) throws Exception {
        var result = articleDao.save(articleMapper.toEntity(articleDto));
        if (result == null) {
            throw new Exception("Something went wrong ! ");
        }
        return articleMapper.toDto(result);
    }

    public List<ArticleDto> getArticles(){
        var articles = articleDao.findAll();
       // articles.forEach(article -> System.out.println(article.getTitle()));
        if (articles.size() != 0) {
            articleMapper.toDtoList(articles).forEach(articleDto -> System.out.println(articleDto.getTitle()));
            return articleMapper.toDtoList(articles);
        }
        return null;
    }

    public List<ArticleDto> getPaginatedArticles(int pageNo, int pageSize, String sortField, String sortDirection){
        this.articleDao.createEntityPage(pageNo, pageSize, sortField, sortDirection);
        var articles = articleDao.findAll();
        if (articles.size() != 0) {
            return articleMapper.toDtoList(articles);
        }
        return null;
    }

    public ArticleDto getOneArticle(Long id){
        var article = this.articleDao.findById(id).get();
        return this.articleMapper.toDto(article);
    }

}
