package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.entity.User;
import cn.dlj1.blog.core.repository.UserRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

/**
* 用户
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@Api(description = "用户")
@RestController
@RequestMapping("/users")
public class UserController extends CrudController<User>{

    @Autowired
    public void init(WebApplicationContext context){
        initCrudController(context, UserRepository.class, true);
    }

}
