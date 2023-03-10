package io.novelis.formationpfe.blog.dto;

import io.novelis.formationpfe.blog.entities.Article;
import io.novelis.formationpfe.blog.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Getter
@Setter
public class CommentDto {
    @NotNull
    private Long commentId;
    @NotNull
    @Size(max = 150)
    private String content;
    @NotNull
    private LocalDate publishingDate;
    @NotNull
    private User user;
    @NotNull
    private Article article;
}
