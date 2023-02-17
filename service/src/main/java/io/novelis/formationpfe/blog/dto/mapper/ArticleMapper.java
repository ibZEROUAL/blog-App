package io.novelis.formationpfe.blog.dto.mapper;

import io.novelis.formationpfe.blog.dto.ArticleDto;
import io.novelis.formationpfe.blog.entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper extends EntityMapper<ArticleDto,Article>  {

}
