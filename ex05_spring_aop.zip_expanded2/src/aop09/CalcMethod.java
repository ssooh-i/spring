package aop09;

import org.springframework.stereotype.Component;

@Component(value = "calc")
public class CalcMethod {

	public void sum(int i, int j) {
		System.out.println(i+" + "+j+" = "+(i+j));
	}

	public void div(int i, int j) throws Exception {
		try {
			System.out.println(i+" / "+j+" = "+(i/j));
		}catch(Exception e){
			throw new RuntimeException("0으로 나눌수 없습니다.");
		}
	}
	
	
}
