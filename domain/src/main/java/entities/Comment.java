package entities;

import io.novelis.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends AbstractEntity {
    @Column(name = "content")
    private String content;

    @Column(name = "publishing_date")
    private LocalDate publishingDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id" , nullable = false)
    private Article article;
}
