package cn.dlj1.blog.core.api.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PageVO<T> extends VO{

    private int pageStart;
    private int pageSize;
    private int pageTotal;
    private long pageEleTotal;

    private List<T> data;

    public static <T> PageVO<T> of(Page<T> page){
        PageVO<T> vo = new PageVO<>();
        vo.setPageStart(page.getNumber() + 1);
        vo.setPageSize(page.getSize());
        vo.setPageTotal(page.getTotalPages());
        vo.setPageEleTotal(page.getTotalElements());

        vo.setData(page.getContent());

        return vo;
    }


}
