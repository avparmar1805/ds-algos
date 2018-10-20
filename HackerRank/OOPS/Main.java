package OOPS;

public class Main {
	public static void main(String[] args) {
		Parent o3 = new Child();
		System.out.println(o3.d1);
		//System.out.println(o3.d2); Not found
		System.out.println(o3.d);
		o3.fun1();
		o3.fun2();
		o3.fun();
	}
	
}
