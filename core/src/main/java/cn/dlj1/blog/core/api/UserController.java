package cn.dlj1.blog.core.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 用户
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:30
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public void list(){

    }

}
