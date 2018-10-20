package StackStory;

public class Client {
	public static void main(String args[]) {
		// Stack st = new DynamicStack(5);

		StacksUsingQueues st = new StacksUsingQueues(5);

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
		st.pop();
		st.display();
		st.pop();
		st.display();
		st.push(80);
		st.display();
		//
		// System.out.println("Size => "+ st.size());
		// System.out.println("isFull => "+ st.isFull());
		//
		// st.display();

		// String str = "[a + {b+ (c+d) + e }+f]"; // "a + {b+ (c+d) + e} +f]" "[a + {b+
		// (c+d) + e} +f]" "[a + {b+ c+d) +
		// // e} +f]" "[a + {b+ (c+d) + e +f]"
		// boolean isBalanced = validExpression(str);
		// System.out.println("isBalanced " + isBalanced);

		// String str = "(a+((((b+c)+d)+e))+f)";
		// boolean hasDuplicates = CheckDuplicates(str);
		// System.out.println("hasDuplicates " + hasDuplicates);
		// stockSpan();
		// increasingDecreasing();
	}

	public static void increasingDecreasing() {
		String str = "diddiddd";// "dddddddd";//"iiiiiiii";//"ddiiidd";
		int counter = 1;
		Stack st = new Stack(str.length() + 1);
		st.push(counter);

		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar != 'i') {
				counter++;
			} else {
				while (st.size() > 0) {
					System.out.print(st.pop() + " ");
				}
				counter++;
			}
			st.push(counter);

		}
		while (st.size() > 0) {
			System.out.print(st.pop() + " ");
		}
	}

	public static boolean CheckDuplicates(String str) {
		Stack st = new Stack(str.length());
		boolean hasDuplicates = false;
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar != ')') {
				st.push(currChar);
				continue;
			} else {
				if (st.top() == '(') {
					return true;
				} else {
					while (st.top() != '(') {
						st.pop();
					}
					st.pop();
				}
			}
		}

		return hasDuplicates;
	}

	public static boolean validExpression(String str) {
		Stack st = new Stack(str.length());
		boolean isBalanced = true;
		for (int i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (currChar == '[' || currChar == '{' || currChar == '(') {
				st.push(currChar);
			} else if (currChar == ']' || currChar == '}' || currChar == ')') {
				if (st.isEmpty()) {
					isBalanced = false;
					break;
				}
				char topChar = (char) st.top();
				if (currChar == ']' && topChar == '[') {
					st.pop();
				}
				if (currChar == '}' && topChar == '{') {
					st.pop();
				}
				if (currChar == ')' && topChar == '(') {
					st.pop();
				}
			}
		}
		if (!st.isEmpty()) {
			isBalanced = false;
		}

		return isBalanced;
	}

	public static void stockSpan() {
		int[] prices = { 30, 35, 40, 60, 50, 45, 48, 49, 55, 70, 20, 29, 35, 30, 20 };
		int[] spans = new int[prices.length];

		Stack st = new Stack(prices.length);

		st.push(0);
		spans[0] = 1;

		for (int i = 1; i < prices.length; i++) {

			while (!st.isEmpty() && prices[i] > prices[st.top()]) { // pop till stack is empty or item is >
				st.pop();
			}

			if (st.isEmpty()) {
				spans[i] = i + 1;
			} else {
				spans[i] = i - st.top();
			}
			st.push(i);
		}

		for (int i = 0; i < spans.length; i++) {
			System.out.print(spans[i] + " ");
		}
	}
}
