package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.Comment;
import cn.dlj1.blog.core.repository.ArticleRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
* 评论
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@Api(description = "评论")
@RestController
@RequestMapping("/comments")
public class CommentController extends CrudController<Comment>{

    @Autowired
    public void init(WebApplicationContext context){
        initCrudController(context, ArticleRepository.class, true);
    }

}
