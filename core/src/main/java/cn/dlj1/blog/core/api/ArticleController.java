package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:30
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public List<Article> list(PageQuery query) {
        Page<Article> page = articleRepository.findAll(query.toPageable());
        return page.getContent();
    }

    @GetMapping("/{id}")
    public Article one(@PathVariable("id") Long id) {
        Article article = articleRepository.getOne(id);
        return article;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Long insert(@RequestBody Article article) {
        Article save = articleRepository.save(article);
        return save.getId();
    }

    @PutMapping("/{id}")
    public Article update(@PathVariable("id") Long id, @RequestBody Article article) {
        article = articleRepository.dynamicUpdate(id, article);
        return article;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        articleRepository.deleteById(id);
    }


}
