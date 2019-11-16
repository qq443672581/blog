package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class DateEntity extends IdEntity {

    @Column(updatable = false)
    private Date createTime;

    @Column(insertable = false)
    private Date updateTime;


    @PrePersist
    void create() {
        this.updateTime = null;
        this.createTime = new Date();
    }

    @PreUpdate
    void update() {
        this.createTime = null;
        this.updateTime = new Date();
    }

}
