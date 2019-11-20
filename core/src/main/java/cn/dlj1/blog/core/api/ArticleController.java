package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.ArticleRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
@Api(description = "文章")
@RestController
@RequestMapping("/articles")
public class ArticleController extends CrudController<Article>{

    @Autowired
    public void init(WebApplicationContext context){
        initCrudController(context, ArticleRepository.class, true);
    }

}
