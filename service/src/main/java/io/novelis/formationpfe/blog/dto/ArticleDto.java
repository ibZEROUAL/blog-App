package io.novelis.formationpfe.blog.dto;

import io.novelis.formationpfe.blog.entities.Comment;
import io.novelis.formationpfe.blog.entities.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    @NotNull
    private Long articleId;
    @NotNull
    private String title;
    @NotNull
    @Size(max = 250)
    private String description;
    @NotNull
    private User user;

    private List<Comment> comments;

}
