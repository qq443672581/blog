package cn.dlj1.blog.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @auth fivewords(443672581 @ qq.com)
 * @date 2019/11/16 11:46
 */
@Getter
@Setter
@MappedSuperclass
public class IdEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "cn.dlj1.blog.core.config.SnowflakeId")
    private Long id;

}
