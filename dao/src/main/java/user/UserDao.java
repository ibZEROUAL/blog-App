package user;

import entities.User;
import io.novelis.common.AbstractDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User, UserRepository> {

    private UserRepository userRepository;
    @Override
    public UserRepository getJpaRepository() {
        return userRepository;
    }

}
