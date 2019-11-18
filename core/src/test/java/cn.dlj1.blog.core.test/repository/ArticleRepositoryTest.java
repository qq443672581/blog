package cn.dlj1.blog.core.test.repository;

import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.entity.Tag;
import cn.dlj1.blog.core.repository.ArticleRepository;
import cn.dlj1.blog.core.repository.TagRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 仓库测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class ArticleRepositoryTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TagRepository tagRepository;

    static Long articleId;
    static Long tagId;

    @Test
    public void test_01() {
        Tag tag = new Tag();
        tag.setTitle("生活");
        tag = tagRepository.save(tag);

        Article article = new Article();
        for (int i = 0; i < 10; i++) {
            article = new Article();
            article.setTitle("文章");
            article.setContent("文章内容");

            article.addTag(tag);

            article = articleRepository.save(article);
        }

        articleId = article.getId();
        tagId = tag.getId();
    }

    @Test
    public void test_02() {
        Article article = articleRepository.getOne(articleId);
        log.info(article.getTags().get(0).getTitle());
        log.info(article.getContent());
    }

    @Test
    public void test_03() throws JsonProcessingException {
        Tag tag = tagRepository.getOne(tagId);
        String string = objectMapper.writeValueAsString(tag);
        log.info(string);
    }

    @Test
    public void test_04() throws JsonProcessingException {
        Page<Article> page = articleRepository.findAll(PageRequest.of(0, 20));
        List<Article> list = page.getContent();
        String string = objectMapper.writeValueAsString(list);
        log.info(string);

    }

}
