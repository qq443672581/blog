package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.api.vo.PageVO;
import cn.dlj1.blog.core.entity.IdEntity;
import cn.dlj1.blog.core.repository.ExtJpaRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
public abstract class CrudController<T extends IdEntity> extends BaseController{

    public void initCrudController(BeanFactory beanFactory, Class<?> clazz, boolean cache){
        this.repository = (ExtJpaRepository<T, Long>) beanFactory.getBean(clazz);

        if(cache){
            this.cacheManger = new ControllerCacheManger(beanFactory, clazz.getSimpleName());
        }
    }

    private ControllerCacheManger cacheManger;
    private ExtJpaRepository<T, Long> repository;

    @ApiOperation("获取列表")
    @GetMapping
    public PageVO<T> list(@ApiParam PageQuery query) {
        PageVO<T> vo;
        if(null != cacheManger && null != (vo = cacheManger.getListCache().get(query.getCacheKey(),PageVO.class))){
            return vo;
        }

        Page<T> page = repository.findAll(query.toPageable());
        vo = PageVO.of(page);

        if(null != cacheManger){
            cacheManger.getListCache().put(query.getCacheKey(), vo);
        }

        return vo;
    }

    @ApiOperation("获取详情")
    @GetMapping("/{id}")
    public T detail(@PathVariable("id") Long id) {
        T t;

        if(null != cacheManger){
            Cache.ValueWrapper wrapper = cacheManger.getItemCache().get(id);
            if(null != wrapper && null != (t = (T) wrapper.get())){
                return t;
            }
        }

        t = repository.getOne(id);

        if(null != cacheManger){
            if (t instanceof HibernateProxy){
                HibernateProxy proxy = (HibernateProxy) t;
                t = (T)  proxy.getHibernateLazyInitializer().getImplementation();
            }
            cacheManger.getItemCache().put(id, t);
        }

        return t;
    }

    @ApiOperation("添加记录")
    @PostMapping
    public Long insert(@RequestBody @ApiParam(name = "entity", value = "数据") T t) {
        T save = repository.save(t);

        if(null != cacheManger){
            cacheManger.getListCache().clear();
        }

        return save.getId();
    }

    @ApiOperation("修改记录")
    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody T t) {
        repository.dynamicUpdate(id, t);

        if(null != cacheManger){
            cacheManger.getListCache().clear();
            cacheManger.getItemCache().evict(id);
        }
    }

    @ApiOperation("删除记录")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);

        if(null != cacheManger){
            cacheManger.getListCache().clear();
            cacheManger.getItemCache().evict(id);
        }
    }

    @Setter
    @Getter
    static class ControllerCacheManger{
        private CacheManager cacheManager;
        private Cache listCache;
        private Cache itemCache;

        public ControllerCacheManger(BeanFactory factory, String cacheName){
            this.cacheManager = factory.getBean(CacheManager.class);
            this.listCache = cacheManager.getCache(cacheName + "-list");
            this.itemCache = cacheManager.getCache(cacheName);
        }
    }

}
