package aop09;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Before,@After,@Pointcut--------------------------
//@Component(value="advice")
//@Aspect
//public class CalcAdvice {
//	@Pointcut("execution(public * *(..))")
//	public void myCalc(){
//	}
//	
//	@Before("myCalc()")
//	public void before(){
//		System.out.println("연산을 시작합니다.");
//	}
//	
//	
//	@AfterThrowing(pointcut="myCalc()" , throwing="e" ) //, throwing="e" 안쓰면 오류남
//	public void afterThrowing(Throwable e){
//		System.out.println("예외가 발생되었습니다.");
//		System.out.println(e.getMessage());
//	}
//	
//	@After("myCalc()")
//	public void after(){
//		System.out.println("연산을 종료합니다.");
//	}
//}


//@Around---------------------------------------------------------------------------------
//@Component(value="advice")
//@Aspect
//public class CalcAdvice {
//	@Pointcut("execution(public * *(..))")
//	public void myCalc(){
//	}
//	
//	@Around("myCalc()")
//	public void around(ProceedingJoinPoint pjp) throws Throwable{
//		System.out.println("연산을 시작합니다.");
//		pjp.proceed();
//		System.out.println("연산을 종료합니다.");
//	}
//	
//	@AfterThrowing(pointcut="execution(public * *(..))" , throwing="e" )
//	public void afterThrowing(Throwable e){
//		System.out.println("예외가 발생되었습니다.");
//		System.out.println(e.getMessage());
//	}
//	
//}


//@Before,@After--------------------------------------------------------------------
@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Before("execution(public * *(..))")
	public void before(){
		System.out.println("연산을 시작합니다.");
	}
	@After("execution(public * *(..))")
	public void after(){
		System.out.println("연산을 종료됩니다.");
	}
	
	@AfterThrowing(pointcut="execution(public * *(..))" , throwing="e" )
	public void afterThrowing(Throwable e){
		System.out.println("예외가 발생되었습니다.");
		System.out.println(e.getMessage());
	}
	
}












