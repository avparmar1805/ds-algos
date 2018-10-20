package june12.oops;

public class Client {

	public static void main(String[] args) {
		// Reuse
//		C obj = new C();
//		obj.Fun();
//		obj.Fun1();
//		System.out.println(obj.d);
//		System.out.println(obj.d1);
		
		P obj = new P();
		System.out.println(obj.d);
		System.out.println(obj.d1);
//		System.out.println(obj.d2); compiler
		obj.Fun();
		obj.Fun1();
//		obj.Fun2(); compiler
		
		System.out.println("********************");
		P obj1 = new C();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
//		System.out.println(obj1.d2); compiler
		System.out.println(((C)obj1).d2);
		obj1.Fun();
		obj1.Fun1();
//		obj1.Fun2(); compiler
		((C)obj1).Fun2();
		
		System.out.println("********************");
//		C obj2 = new P(); // not allowed by compiler
		
		System.out.println("************************");
		C obj3 = new C();
		System.out.println(obj3.d);
		System.out.println(obj3.d1);
		System.out.println(obj3.d2); 
		obj3.Fun();
		obj3.Fun1();
		obj3.Fun2(); 
	}

}
