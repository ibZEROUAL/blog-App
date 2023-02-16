package io.novelis.common;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends AbstractEntity, Q extends JpaRepository<T, Long>>{

    @Qualifier(value = "entityManagerFactory")
    private EntityManager entityManager;

    public abstract Q getJpaRepository();

    public T save(T entity) {
        return getJpaRepository().save(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        getJpaRepository().delete(entity);
    }

    public void deleteById(Long id) {
        getJpaRepository().deleteById(id);
    }

    public boolean existsById(Long id) {
        return getJpaRepository().existsById(id);
    }

    public Optional<T> findById(Long id) {
        return getJpaRepository().findById(id);
    }

    public List<T> findAll() {
        return getJpaRepository().findAll();
    }

    protected JPAQueryFactory getJPAQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }


}
