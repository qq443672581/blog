package cn.dlj1.blog.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
@TableName("article")
public class Article extends BaseEntity{

    private String title;
    private String content;

    private Date createTime;

}
