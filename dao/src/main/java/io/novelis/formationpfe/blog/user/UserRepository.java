package io.novelis.formationpfe.blog.user;

import io.novelis.formationpfe.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
