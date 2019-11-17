package cn.dlj1.blog.core.service;

import cn.dlj1.blog.core.entity.Article;
import cn.dlj1.blog.core.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "article")
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Cacheable(key = "#tagId + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<Article> findAllByTagsId(Pageable pageable, Long tagId){
        return articleRepository.findAllByTagsId(pageable, tagId);
    }

    @Cacheable(key = "#tagTitle + '-' + #pageable.pageNumber + '-' + #pageable.pageSize")
    public Page<Article> findAllByTagsTitle(Pageable pageable, String tagTitle){
        return articleRepository.findAllByTagsTitle(pageable, tagTitle);
    }

}
