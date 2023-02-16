package entities;

import io.novelis.common.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int Age;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Comment> comments;

}
