package cn.dlj1.blog.core.api.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ApiModel
public class PageQuery extends Query {

    @ApiModelProperty(name = "page_start")
    private int pageStart = 1;

    @ApiModelProperty(name = "page_size")
    private int pageSize = 10;

    private String pageSortField = "id";
    private String pageSortType = "DESC";

    public Pageable toPageable() {
        Sort.Order order;
        if ("DESC".equalsIgnoreCase(pageSortType)) {
            order = Sort.Order.desc(pageSortField);
        } else {
            order = Sort.Order.asc(pageSortField);
        }
        Sort sort = Sort.by(order);


        return PageRequest.of(pageStart - 1, pageSize, sort);
    }

    /**
    * 緩存key
    *
    * @auth fivewords(443672581@qq.com)
    * @date 2019/11/20 20:55
    */
    public String getCacheKey() {
        return pageStart + "-" + pageSize + "-" + pageSortField + "-" + pageSortType;
    }

}
