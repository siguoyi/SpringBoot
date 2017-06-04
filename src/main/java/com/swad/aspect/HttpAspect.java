package com.swad.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenlei on 2017/6/4.
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.swad.controller.StudentController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void logBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();
        //url
        LOGGER.info("url={}", httpServletRequest.getRequestURL());

        //method
        LOGGER.info("method={}", httpServletRequest.getMethod());

        //ip
        LOGGER.info("ip={}", httpServletRequest.getRemoteAddr());

        //类方法
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        LOGGER.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void logAfter(){
        LOGGER.info("222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void afterReturning(Object object){
        LOGGER.info("response={}", object);
    }
}
