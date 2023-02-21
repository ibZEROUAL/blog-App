package io.novelis.formationpfe.blog;

import io.novelis.formationpfe.blog.dto.ArticleDto;
import io.novelis.formationpfe.blog.dto.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ArticleDto> getAllArticles () {
        return this.articleService.getArticles();
    }



}
