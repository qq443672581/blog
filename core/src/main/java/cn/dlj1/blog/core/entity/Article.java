package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 *
 */
@Getter
@Setter
@Entity
public class Article extends DateEntity {

    private String title;
    private String content;

}
