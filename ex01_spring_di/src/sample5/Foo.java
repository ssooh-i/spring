package sample5;

public class Foo implements InterFoo{
	public Foo() {
	
	}
	
	public Foo(String str) {
		System.out.println(str);
		System.out.println("-----------------");
	}
	
	public Foo(int n,String str) {
		System.out.println(n+"  "+str);
		System.out.println("-----------------");
	}
	
	public Foo(String str,int n,boolean flag) {
		System.out.println(str+"  "+n+"  "+flag);
		System.out.println("--------------------");
	}
	
	public Foo(Bar bar) {
		System.out.println(bar);
	}
}
