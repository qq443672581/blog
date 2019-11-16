package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.Article;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* 文章
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping
    public List<Article> list(){
        return null;
    }

}
