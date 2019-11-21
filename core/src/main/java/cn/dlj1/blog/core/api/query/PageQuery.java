package cn.dlj1.blog.core.api.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ApiModel
public class PageQuery extends Query {

    @Min(1)
    @ApiModelProperty(name = "page_start", value = "页码")
    private int pageStart = 1;

    @Max(100)
    @Min(10)
    @ApiModelProperty(name = "page_size", value = "每页数量")
    private int pageSize = 10;

    @ApiModelProperty(name = "page_sort_field", value = "排序字段")
    private String pageSortField = "id";

    @Pattern(regexp = "DESC|ASC")
    @ApiModelProperty(name = "page_sort_type", value = "排序类型")
    private String pageSortType = "DESC";

    public Pageable toPageable() {
        Sort.Order order;
        if (Sort.Direction.DESC.name().equalsIgnoreCase(pageSortType)) {
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
