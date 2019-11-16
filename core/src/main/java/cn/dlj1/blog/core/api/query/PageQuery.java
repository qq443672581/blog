package cn.dlj1.blog.core.api.query;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageQuery extends Query {

    private int pageStart = 1;
    private int pageSize = 20;

    private String pageSortField = "id";
    private String pageSortType = "DESC";

    public Pageable toPageable() {
        Sort.Order order = null;
        if ("DESC".equalsIgnoreCase(pageSortType)) {
            order = Sort.Order.desc(pageSortField);
        } else {
            order = Sort.Order.asc(pageSortField);
        }
        Sort sort = Sort.by(order);


        return PageRequest.of(pageStart - 1, pageSize, sort);
    }
}
