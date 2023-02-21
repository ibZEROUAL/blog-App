package io.novelis.formationpfe.blog;

import io.novelis.formationpfe.blog.dto.ArticleDto;
import io.novelis.formationpfe.blog.dto.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping("/{pageNo}")
    public ResponseEntity<List<ArticleDto>> getAllArticles(@PathVariable (value = "pageNo") int pageNo,
                                                           @RequestParam("sortField") String sortField,
                                                           @RequestParam("sortDir") String sortDir) {
        int pageSize = 2;
        return ResponseEntity.ok().body(this.articleService.getPaginatedArticles(pageNo , pageSize ,sortField , sortDir));
    }

    @GetMapping("")
    public List<ArticleDto> getAllArticles() {
        // this.articleService.getArticles().forEach(articleDto -> System.out.println(articleDto.getTitle()));
        return this.articleService.getArticles();
    }

    @GetMapping("/{id}")
    public ArticleDto getArticle(@PathVariable Long id) {
        // this.articleService.getArticles().forEach(articleDto -> System.out.println(articleDto.getTitle()));
        return this.articleService.getOneArticle(id);
    }

}
