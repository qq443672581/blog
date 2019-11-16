package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DateEntity extends IdEntity {

    private Date createTime;

    private Date updateTime;


}
