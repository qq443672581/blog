package cn.dlj1.blog.core.exception;

import cn.dlj1.blog.core.api.vo.ErrResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlers {

    /*
     * 资源部存在
     */
    @ExceptionHandler(value = {EmptyResultDataAccessException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrResponse notFound(){
        return ErrResponse.NOT_FOUND;
    }

}
