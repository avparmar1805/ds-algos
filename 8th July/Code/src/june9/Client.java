package june9;

public class Client {

	public static void main(String[] args) {
//		Person p1 = new Person();
//		p1.age = 10;
//		p1.name = "A";
//		p1.saysHi();
//		
//		Person p2 = p1;
//		p2.age = 20;
//
//		p1.saysHi();
		
		Person p1 = new Person(10, "A");
		Person p2 = new Person(20, "B");
		
		p1.saysHi();
		p2.saysHi();
		swap2(p1, p2);
		p1.saysHi();
		p2.saysHi();
	}

	private static void swap(Person p1, Person p2) {
		Person temp = p1;
		p1 = p2;
		p2 = temp;
	}

	private static void swap2(Person p1, Person p2){
		int tage = p1.age;
		p1.age = p2.age;
		p2.age = tage;
		
		String tname = p1.name;
		p1.name = p2.name;
		p2.name = tname;
	}
}
