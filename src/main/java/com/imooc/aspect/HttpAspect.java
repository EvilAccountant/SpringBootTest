package com.imooc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dell on 2017-5-16.
 */
@Aspect
//引入Spring容器中
@Component

//定义切面类
public class HttpAspect {

    //用log形式输出替换Syso形式输出
    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    //Pointcut注解让log方法等同于GirlController之下的所有方法，若要改为单一方法，最后*改为该方法名即可
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log(){

    }


    //Before注解让doBefore方法在log方法执行前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //javax的HttpServletRequest
        HttpServletRequest request =attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method 请求方法
        logger.info("method={}", request.getMethod());


        //ip地址
        logger.info("ip={}", request.getRemoteAddr());


        //类 方法 的调用
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());


        //传入参数
        logger.info("args={}", joinPoint.getArgs());

    }

    //After注解让doAfter方法在log方法执行前执行
    @After("log()")
    public void doAfter(){
        logger.info("Do you like what you see");
    }


    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
