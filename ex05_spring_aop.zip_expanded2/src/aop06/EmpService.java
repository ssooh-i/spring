package aop06;

import org.springframework.stereotype.Component;

@Component(value="emp")    //기본값: empService
public class EmpService implements Person{
	@Override
	public void work() {
		System.out.println("직원 서비스 진행");
	}
}
