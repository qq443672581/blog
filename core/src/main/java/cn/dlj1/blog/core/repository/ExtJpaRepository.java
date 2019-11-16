package cn.dlj1.blog.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface ExtJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T dynamicUpdate(ID id, T entity);

}
