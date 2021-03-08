package com.ash.server.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 全局异常处理
 * @Author ash
 * @Date 2021/2/10 15:14
 * @Version 1.0
 **/
@RestControllerAdvice
public class GlobalException {

//    @ExceptionHandler(SQLException.class)
//    public RespBean mySqlException(SQLException e){
//        if (e instanceof SQLIntegrityConstraintViolationException){
//            return RespBean.error("该数据有关联数据，操作失败！");
//        }
//        return RespBean.error("数据库异常，操作失败！");
//    }

}
