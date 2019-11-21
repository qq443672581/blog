package cn.dlj1.blog.core.repository.ext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
* 仓库通用扩展
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/21 22:48
*/
@NoRepositoryBean
public interface ExtJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T dynamicUpdate(ID id, T entity);

}
