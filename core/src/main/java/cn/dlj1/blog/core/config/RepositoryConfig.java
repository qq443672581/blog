package cn.dlj1.blog.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;

/**
*
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 00:19
*/
@Configuration
@MapperScans(@MapperScan(basePackages = "cn.dlj1.blog.core.repository"))
public class RepositoryConfig {
}
