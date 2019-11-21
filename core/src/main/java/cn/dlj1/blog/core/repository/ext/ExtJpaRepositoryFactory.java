package cn.dlj1.blog.core.repository.ext;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.core.RepositoryMetadata;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class ExtJpaRepositoryFactory<T, I extends Serializable> extends JpaRepositoryFactory {
    private final EntityManager em;

    public ExtJpaRepositoryFactory(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return SimpleExtJpaRepository.class;
    }

}