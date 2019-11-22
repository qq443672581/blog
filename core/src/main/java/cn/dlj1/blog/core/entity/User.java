package cn.dlj1.blog.core.entity;

import cn.dlj1.blog.core.config.ValidateGroup;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.DigestUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity(name = "user")
public class User extends DateEntity{

    @NotNull(groups = ValidateGroup.Insert.class)
    @Length(min = 6, max = 16)
    @Column(unique = true, length = 16, updatable = false, nullable = false)
    private String username;

    @NotNull
    @Length(min = 6, max = 32)
    @Column(length = 32, nullable = false)
    private String password;

    @PrePersist
    void insert() {
        this.password = DigestUtils.md5DigestAsHex(this.password.getBytes());
    }
    @PreUpdate
    void update() {
        if(null != this.password){
            this.password = DigestUtils.md5DigestAsHex(this.password.getBytes());
        }
    }

}
