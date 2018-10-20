package StackStory;

public class Stack {

	protected int[] data;
	private int tos = -1;

	public Stack(int cap) {
		this.data = new int[cap];
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return tos == -1;
	}

	public boolean isFull() {
		return tos == data.length - 1;
	}

	public void push(int val) {
		if (!isFull()) {
			data[++tos] = val;
		} else {
			throw new Error("Stack is full");
		}
	}

	public int pop() {
		int retVal = -1;
		if(!isEmpty()) {
			retVal = data[tos];
			data[tos] = 0;
			tos--;
		} else {
			throw new Error("Stack is empty");
		}
		
		return retVal;
	}
	
	public void display() {
		if(!isEmpty()) {
			for(int i = tos; i >= 0; i--) {
				System.out.print(data[i] + " ");
			}
		}
		System.out.println();
	}
	
	public int top() {
		return data[this.tos];
	}

}
