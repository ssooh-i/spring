package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AdviceEx {
	  //@Before("within(aop08.CoreEx)")   // pointcut 주입
		@Before("execution(* zeroMethod(..))")
		public void before(){
			System.out.println("Joinpoint앞에서 실행되는 Advice");
		}
		
		//@AfterThrowing(pointcut="within(aop08.CoreEx)", throwing="e" )
		@AfterThrowing(pointcut="execution(* zeroMethod(..))", throwing="e" )
		public void afterThrowing(Throwable e){
			System.out.println("예외가 실행될때 호출되는 Advice");
			System.out.println(e.getMessage());
		}
		
		//@AfterReturning(pointcut="within(aop08.CoreEx)", returning="ret" )
		@AfterReturning(pointcut="execution(* zeroMethod(..))", returning="ret" )
		public void afterReturing(Object ret){
			System.out.println("Joinpoint가 정상 종료후 실행되는 Advice");
		}
		
		//@After("within(aop08.CoreEx)")
		@After("execution(* zeroMethod(..))")
		public void after(){
			System.out.println("Joinpoint뒤에서 실행되는 Advice");
		}
		
		//@Around("within(aop08.CoreEx)")
		@Around("execution(* zeroMethod(..))")
		public Object around(ProceedingJoinPoint  jp) throws Throwable{
			System.out.println("Joinpoint 전역에서 실행되는 Advice");
			return jp.proceed();
		}	
}


/*  
Annotation(어노테이션)
- Aspect어노테이션을 이용하여 Aspect클래스에 직접 Advice와 Pointcut등을 설정한다
- <aop:aspectj-autoproxy/>를 추가
- Aspect Class를 <bean>으로 등록

@Aspect : Aspect클래스 선언
@Before("pointcut")
@AfterReturning(pointcut="", returning="")
@AfterThrowing(pointcut="", throwing="")
@After("pointcut")
@Around("point") : 전반적

Around를 제외한 나머지 메서드들은 첫번째 인자값으로 JoinPoint를 가질수 있다
Around메서드는 인자로 ProceedingJoinPoint를 가질수 있다
*/