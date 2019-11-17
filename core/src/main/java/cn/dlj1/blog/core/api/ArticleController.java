package cn.dlj1.blog.core.api;

import cn.dlj1.blog.core.api.query.PageQuery;
import cn.dlj1.blog.core.api.vo.PageVO;
import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.entity.Tag;
import cn.dlj1.blog.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public PageVO<Article> list(PageQuery query) {
        Article a = new Article();
        Tag tag = new Tag();
        tag.setId(13L);
        a.addTag(tag);

        Page<Article> page = articleRepository.findAll(Example.of(a), query.toPageable());
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
