package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.ArticleRepository;
import cn.dlj1.blog.core.repository.ExtJpaRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
@Api(value = "文章")
@RestController
@RequestMapping("/articles")
public class ArticleController extends CrudController<Article>{

    @Override
    public ExtJpaRepository getRepository() {
        return articleRepository;
    }

    @Autowired
    private ArticleRepository articleRepository;



}
