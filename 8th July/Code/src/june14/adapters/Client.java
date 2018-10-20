package june14.adapters;

import june12.stacks.DynamicStack;

public class Client {

	public static void main(String[] args) {
//		StackUsingQueuesPopEfficient st = new StackUsingQueuesPopEfficient(5);
//		st.push(10);
//		st.push(20);
//		st.push(30);
//		st.push(40);
//		st.push(50);
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());
//		System.out.println(st.pop());
		int[] prices = {10, 20, 30, 60, 40, 30, 35, 50, 65, 45, 50};
		int[] spans = stockSpans(prices);
		for(int val: spans){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}
	
	private static int[] stockSpans(int[] prices){
		int[] spans = new int[prices.length];
		final double pi = 3.14;
		
		
		DynamicStack st = new DynamicStack(prices.length);
		
		st.push(0);
		spans[0] = 1;
		
		for(int i = 1; i < prices.length; i++){
			// pops
			while(st.size() > 0 && prices[i] > prices[st.top()]){
				st.pop();
			}
			
			// span calculation
			spans[i] = st.size() == 0? i + 1: i - st.top();
			
			// push
			st.push(i);
		}
		
		return spans;
	}

}
