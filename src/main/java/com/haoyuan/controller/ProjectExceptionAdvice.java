package com.haoyuan.controller;

import com.haoyuan.domain.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R otherException(Exception ex){

        //给运维发消息
        //记录日志
        //发送邮件给开发人员


        //将错误信息打印到控制台上
        ex.printStackTrace();
        R res=new R();
        res.setFlag(false);
        res.setMsg("系统错误，请联系管理员");
        return res;

    }
}
