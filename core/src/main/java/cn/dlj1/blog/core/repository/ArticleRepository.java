package cn.dlj1.blog.core.repository;

import cn.dlj1.blog.core.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
*
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 12:10
*/
public interface ArticleRepository extends ExtJpaRepository<Article, Long> {

    Page<Article> findAllByTagsId(Pageable pageable, Long tagId);

    Page<Article> findAllByTagsTitle(Pageable pageable, String tagTitle);

}
