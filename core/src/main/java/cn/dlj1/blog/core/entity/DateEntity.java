package cn.dlj1.blog.core.entity;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(example = "2000-01-01 00:00:00")
    @Column(updatable = false)
    private Date createTime;

    @ApiModelProperty(example = "2000-01-01 00:00:00")
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
