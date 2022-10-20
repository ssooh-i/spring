package anno03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//기본생성자, dept만 setter, toString추가
@Component
public class Engineer {
//	@Autowired
//	@Qualifier(value="emp1")   //@Autowired, @Qualifier: 스프링 전용
	@Resource(name = "emp1")   //@Resource: 자바전용 
	private Emp emp;
	
	@Resource(name="dev_dept")
	private String dept;
	
	public Engineer() {
		super();
	}

//	public void setDept(String dept) {
//		this.dept = dept;
//	}
	
	@Override
	public String toString() {
		return emp.toString()+"\n"+dept+"에 근무합니다";
	}
}
