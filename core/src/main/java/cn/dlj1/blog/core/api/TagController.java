package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.TagRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 标签
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@Api(description = "标签")
@RestController
@RequestMapping("/tags")
public class TagController extends CrudController<Article>{

    @Autowired
    public void init(BeanFactory factory){
        initCrudController(factory, TagRepository.class, true);
    }

}
