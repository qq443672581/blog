package cn.dlj1.blog.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
*
*
* @auth fivewords(443672581@qq.com)
* @date 2019/11/16 11:46
*/
@Getter
@Setter
public class BaseEntity {

    @TableId(type = IdType.ID_WORKER)
    private Long id;

}
