package june9.stacks;

public class Client {

	public static void main(String[] args) {
		Stack st = new Stack(5);
		
		st.push(10);
		st.display();
		
		st.push(20);
		st.display();
		
		st.push(30);
		st.display();
		
		st.push(40);
		st.display();
		
		st.push(50);
		st.display();
		
		st.push(60);
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
		
		System.out.println(st.top());
		System.out.println(st.pop());
		st.display();
	}

}
