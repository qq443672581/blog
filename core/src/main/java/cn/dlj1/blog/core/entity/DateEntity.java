package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class DateEntity extends IdEntity {

    private Date createTime;

    private Date updateTime;


}
