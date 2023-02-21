package io.novelis.formationpfe.blog.user;

import io.novelis.formationpfe.blog.entities.User;
import io.novelis.formationpfe.blog.AbstractDao;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User, UserRepository> {

    private UserRepository userRepository;
    @Override
    public UserRepository getJpaRepository() {
        return userRepository;
    }

    @Override
    public Page<User> createEntityPage(int pageNo, int pageSize, String sortField, String sortDirection) {
        return null;
    }

}
