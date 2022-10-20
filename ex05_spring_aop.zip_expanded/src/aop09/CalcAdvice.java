package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Pointcut("execution(public * *(..))")
	public void myCalc(){
		
	}
	@Around("myCalc()")
	public void around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("** 연산시작 **");
		pjp.proceed();		
		System.out.println("** 연산종료 **\n\n");
	}	
}
//---------------------------------------------------------------------------------
/*
@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Pointcut("execution(public * *(..))")
	public void myCalc(){
		
	}
	@Before("myCalc()")
	public void before(){
		System.out.println("연산을 시작합니다.");
	}
	@After("myCalc()")
	public void after(){
		System.out.println("연산을 종료합니다\n");
	}
}
*/
//---------------------------------------------------------------------
/*
@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Before("execution(public * *(..))")
	public void before(){
		System.out.println("연산을 시작합니다.");
	}
	@After("execution(public * *(..))")
	public void after(){
		System.out.println("연산을 종료합니다\n");
	}
}
*/












