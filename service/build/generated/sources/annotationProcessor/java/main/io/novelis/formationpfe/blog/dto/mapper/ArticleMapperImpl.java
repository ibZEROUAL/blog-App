package io.novelis.formationpfe.blog.dto.mapper;

import io.novelis.formationpfe.blog.dto.ArticleDto;
import io.novelis.formationpfe.blog.entities.Article;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-20T17:50:21+0100",
    comments = "version: 1.5.0.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public Article toEntity(ArticleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Article article = new Article();

        return article;
    }

    @Override
    public ArticleDto toDto(Article entity) {
        if ( entity == null ) {
            return null;
        }

        ArticleDto articleDto = new ArticleDto();

        return articleDto;
    }

    @Override
    public List<Article> toEntityList(List<ArticleDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Article> list = new ArrayList<Article>( dtoList.size() );
        for ( ArticleDto articleDto : dtoList ) {
            list.add( toEntity( articleDto ) );
        }

        return list;
    }

    @Override
    public List<ArticleDto> toDtoList(List<Article> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ArticleDto> list = new ArrayList<ArticleDto>( entityList.size() );
        for ( Article article : entityList ) {
            list.add( toDto( article ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(ArticleDto dto, Article entity) {
        if ( dto == null ) {
            return;
        }
    }
}
