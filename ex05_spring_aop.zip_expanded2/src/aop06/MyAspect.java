package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component        
public class MyAspect{  // 기본값: myAspect
	@Pointcut("execution(public void aop06.*.*())")
	public void myWork() {
	}
	
	@Before("myWork()")
	public void login(JoinPoint joinPoint) {
		System.out.println("로그인 처리");
	}
	
	@After("myWork()")
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃 처리");
	}
}
