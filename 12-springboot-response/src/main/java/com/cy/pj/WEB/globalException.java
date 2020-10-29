package com.cy.pj.WEB;

import com.cy.pj.pojo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalException {
    private static final Logger log= LoggerFactory.getLogger(globalException.class);//2
    @ExceptionHandler(ArithmeticException.class)
    public ResponseResult doHandleArithmeticException(ArithmeticException e){
        e.printStackTrace();
        log.info("exception {}",e.getMessage());
        return new ResponseResult(e);//封装异常结果
    }

}
