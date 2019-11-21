package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity(name = "comment")
public class Comment extends DateEntity {
}
