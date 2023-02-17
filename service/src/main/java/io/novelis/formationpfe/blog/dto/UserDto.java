package io.novelis.formationpfe.blog.dto;

import io.novelis.formationpfe.blog.entities.Article;
import io.novelis.formationpfe.blog.entities.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
public class UserDto {
    @NotNull
    private Long userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private int Age;
    private List<Article> articles;
    private List<Comment> comments;
}
