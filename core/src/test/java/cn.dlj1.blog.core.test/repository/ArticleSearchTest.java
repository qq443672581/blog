package cn.dlj1.blog.core.test.repository;

import cn.dlj1.blog.core.entity.Article;
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
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class ArticleSearchTest {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    CacheManager cacheManager;

    @Test
    public void test_01() throws JsonProcessingException {
        Page<Article> page = articleRepository.findAllByTagsTitle(PageRequest.of(0, 10), "生活");

        log.info(objectMapper.writeValueAsString(page.getContent()));
    }

    @Test
    public void test_02() throws JsonProcessingException {
        Page<Article> page = articleRepository.findAllByTagsTitle(PageRequest.of(0, 10), "生活");

        log.info(objectMapper.writeValueAsString(page.getContent()));
        log.info("{}", cacheManager.getCacheNames());

        log.info(cacheManager.getClass().getName());
    }


}
