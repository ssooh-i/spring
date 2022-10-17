package sample6;

public class Engineer extends Emp{
	private String dept;

	public Engineer() {
		super();
	}
	public Engineer(String name, int salary) {
		super(name, salary);
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return super.toString() + "부서 : " + dept + "(기술부)";
	}
}








