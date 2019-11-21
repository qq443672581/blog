package cn.dlj1.blog.core.api.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrResponse {

    public static final ErrResponse NOT_FOUND = new ErrResponse(1000, "资源不存在");
    public static final ErrResponse VALIDATE_FAIL = new ErrResponse(1001, "验证失败");

    private int code;

    private String msg;

    public ErrResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

}
