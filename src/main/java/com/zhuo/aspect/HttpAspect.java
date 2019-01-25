package com.zhuo.aspect;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.zhuo.controller.AreaController.*(..))")
	public void log() {
	}
	
	@Before("log()")
	public void doBefore(JoinPoint point) {
		ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest  request = (HttpServletRequest) attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURL());
		
		//method
		logger.info("method={}",request.getMethod());
		
		//ip
		logger.info("ip={}",request.getRemoteAddr());
		
		//class_method
		logger.info("class_method={}",point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
		
		//参数
		logger.info("args={}",point.getArgs());
				
		
	}
	
	@After("log()")
	public void doAfter() {
		logger.info("22222222222");
	}
	
	@AfterReturning(returning ="object" ,pointcut="log()")
	public void doAfterReturning(Object object) {
		logger.info("response={}",object.toString());
	}
	
}
