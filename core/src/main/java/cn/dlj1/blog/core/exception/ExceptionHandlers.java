package cn.dlj1.blog.core.exception;

import cn.dlj1.blog.core.api.vo.ErrResponse;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import java.lang.reflect.Field;

@ControllerAdvice
public class ExceptionHandlers {

    /*
     * 资源部存在
     */
    @ExceptionHandler(value = {EmptyResultDataAccessException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrResponse notFound() {
        return ErrResponse.NOT_FOUND;
    }

    /**
    * 参数有误
    *
    * @auth fivewords(443672581@qq.com)
    * @date 2019/11/21 22:33
    */
    @ExceptionHandler(value = {org.springframework.validation.BindException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrResponse bindException(BindException bindException) {
        BindingResult result = bindException.getBindingResult();
        FieldError fieldError = result.getFieldError();
        String fileName = fieldError.getField();

        try {
            Field field = result.getTarget().getClass().getDeclaredField(fieldError.getField());
            ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
            if(null != annotation){
                fileName = annotation.value();
            }
        } catch (NoSuchFieldException e) {
        }

        String message = String.format("字段[%s]验证失败:%s", fileName, fieldError.getDefaultMessage());
        return new ErrResponse(ErrResponse.VALIDATE_FAIL.getCode(), message);
    }

}
