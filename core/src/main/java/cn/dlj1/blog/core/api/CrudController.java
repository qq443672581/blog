package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.api.vo.PageVO;
import cn.dlj1.blog.core.entity.IdEntity;
import cn.dlj1.blog.core.repository.ExtJpaRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
public abstract class CrudController<T extends IdEntity> extends BaseController{

    public abstract ExtJpaRepository<T, Long> getRepository();

    @Cacheable(cacheNames =  "article", key = "#query.pageSortField + '-' +#query.pageSortType + '-' + #query.pageStart + '-' + #query.pageSize")
    @GetMapping
    @ApiOperation("获取列表")
    public PageVO<T> list(@ApiParam PageQuery query) {
        Page<T> page = getRepository().findAll(query.toPageable());
        return PageVO.of(page);
    }

    @GetMapping("/{id}")
    public T detail(@PathVariable("id") Long id) {
        T t = getRepository().getOne(id);
        return t;
    }

    @PostMapping
    public Long insert(@RequestBody T t) {
        T save = getRepository().save(t);
        return save.getId();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody T t) {
        getRepository().dynamicUpdate(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        getRepository().deleteById(id);
    }

}
