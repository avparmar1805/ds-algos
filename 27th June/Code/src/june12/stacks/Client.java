package june12.stacks;

public class Client {

	public static void main(String[] args) {
		Stack st = new DynamicStack(5);

		// st.push(10);
		// st.display();
		//
		// st.push(20);
		// st.display();
		//
		// st.push(30);
		// st.display();
		//
		// st.push(40);
		// st.display();
		//
		// st.push(50);
		// st.display();
		//
		// st.push(60);
		// st.display();
		System.out.println(hasDuplicateBrackets("((a+b)+((c+d)))"));
	}

	private static boolean hasDuplicateBrackets(String str) {
		Stack st = new Stack(str.length());

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch != ')') {
				st.push(ch);
			} else {
				if(st.top() == '('){
					return true;
				} else {
					while(st.top() != '('){
						st.pop();
					}
					st.pop();
				}
			}
		}

		return false;
	}

	private static boolean hasBalancedBrackets(String str){
		Stack st = new Stack(str.length());
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch == '(' || ch == '{' || ch == '['){
				st.push(ch);
			} else if (ch == ')'){
				if(st.size() == 0){
					return false; // more closing
				} else if(st.top() != '('){
					return false; // mismatch
				} else {
					st.pop();
				}
			}  else if (ch == '}'){
				if(st.size() == 0){
					return false; // more closing
				} else if(st.top() != '{'){
					return false; // mismatch
				} else {
					st.pop();
				}
			}  else if (ch == ']'){
				if(st.size() == 0){
					return false; // more closing
				} else if(st.top() != '['){
					return false; // mismatch
				} else {
					st.pop();
				}
			}
		}
		
		if(st.size() > 0){
			return false; // more opening
		} else {
			return true;
		}
	}
}
