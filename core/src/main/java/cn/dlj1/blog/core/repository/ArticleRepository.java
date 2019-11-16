package cn.dlj1.blog.core.repository;

import cn.dlj1.blog.core.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
*
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 12:10
*/
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
