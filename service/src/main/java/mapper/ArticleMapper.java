package mapper;

import dto.ArticleDto;
import entities.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring" , unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper extends EntityMapper<ArticleDto,Article>  {

}
