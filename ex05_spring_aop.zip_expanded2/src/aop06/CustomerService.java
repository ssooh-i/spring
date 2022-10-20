package aop06;

import org.springframework.stereotype.Component;

@Component(value="customer")    //기본값: customerService
public class CustomerService implements Person{
	@Override
	public void work() {
		System.out.println("고객 서비스 진행");
	}
}
