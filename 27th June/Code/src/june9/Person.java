package june9;

public class Person {
	String name = "NA"; // can override the java default
	int age = -1; // can override the java default
	
	public void saysHi(){
		System.out.println(this.name + "[" + this.age + "] years old says hi.");
	}
	
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	public Person(int age){
		this(age, "NA");
	}
}
