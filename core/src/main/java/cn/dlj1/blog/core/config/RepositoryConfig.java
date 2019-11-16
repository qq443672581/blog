package cn.dlj1.blog.core.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 仓库配置
 *
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 00:19
 */
@Configuration
@MapperScans(@MapperScan(basePackages = "cn.dlj1.blog.core.repository"))
public class RepositoryConfig {

    @Component
    public static class MyMetaObjectHandler implements MetaObjectHandler {

        @Override
        public void insertFill(MetaObject metaObject) {

            if (metaObject.hasSetter("createTime")) {
                setFieldValByName("createTime", new Date(), metaObject);
            }

        }

        @Override
        public void updateFill(MetaObject metaObject) {

            if (metaObject.hasSetter("updateTime")) {
                setFieldValByName("updateTime", new Date(), metaObject);
            }

        }
    }

}
