package cn.dlj1.blog.core.api;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {

//    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("name");
    }

}
