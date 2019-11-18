package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.api.vo.PageVO;
import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
@RestController
@RequestMapping("/articles")
@CacheConfig(cacheNames = "article")
public class ArticleController extends BaseController{


    @Autowired
    private ArticleRepository articleRepository;

    @Cacheable(key = "#query.pageSortField + '-' +#query.pageSortType + '-' + #query.pageStart + '-' + #query.pageSize")
    @GetMapping
    public PageVO<Article> list(PageQuery query) {
        Example<Article> example = Example.of(new Article(), ExampleMatcher.matching().withIgnorePaths("content"));

        Page<Article> page = articleRepository.findAll(example, query.toPageable());
        return PageVO.of(page);
    }

    @GetMapping("/{id}")
    public Article detail(@PathVariable("id") Long id) {
        Article article = articleRepository.getOne(id);
        return article;
    }

    @PostMapping
    public Long insert(@RequestBody Article article) {
        Article save = articleRepository.save(article);
        return save.getId();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Article article) {
        articleRepository.dynamicUpdate(id, article);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
    }

}
