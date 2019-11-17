package cn.dlj1.blog.core;

import cn.dlj1.blog.core.repository.impl.ExtJpaRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * start
 *
 * @auth fivewords(443672581@qq.com)
 * @date 2019/11/15 23:57
 */
@SpringBootApplication
@EnableCaching
@EnableJpaRepositories(repositoryFactoryBeanClass = ExtJpaRepositoryFactoryBean.class)
public class BlogCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogCoreApplication.class, args);
    }

}

