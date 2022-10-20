package aop07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//횡단(공통)관심 사항
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invo) throws Throwable {
		String methodName = invo.getMethod().getName();
		StopWatch sw=new StopWatch();

		sw.start(methodName);

		System.out.println("From [bean1.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " is calling");
		Object obj=invo.proceed();           //sayHello() 주입

		sw.stop();
		System.out.println("[LOG]METHOD : " + methodName + " is called");
		System.out.println("[LOG]처리시간   : " + sw.getTotalTimeMillis()/1000 + "초");

		return obj;
	}
	
	public void logAround(ProceedingJoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		StopWatch sw = new StopWatch();
		
		System.out.println("From [bean2.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " is Calling");
		sw.start();
		
		jp.proceed();
		
		sw.stop();
		System.out.println("[LOG]METHOD : " + methodName + " was done");
		System.out.println("[LOG]처리시간   : " + sw.getTotalTimeMillis()/1000 + " 초");
	}
	

}













