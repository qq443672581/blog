package cn.dlj1.blog.core.api.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQuery extends Query{

    private int pageStart = 1;
    private int pageSize = 20;

}
