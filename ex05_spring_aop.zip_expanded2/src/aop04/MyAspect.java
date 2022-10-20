package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/*
@Aspect 어노테이션
설정파일에서 Advice 및 pointcut등을 설정하지 않고 자동적으로 advice를 적용

@Before("execution(public void aop04.EmpService.work())") 형식으로 사용
*/

//<aop:aspect ref="myAdvice">가 밑에꺼 처럼
@Aspect 
public class MyAspect{
	@Before("execution(public void aop04.*.*())")
	public void login(JoinPoint joinPoint) {
		System.out.println("로그인 처리");
	}
	
	@After("execution(public void aop04.*.work())")
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃 처리");
	}
}
