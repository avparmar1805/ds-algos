package StackStory;

import QueueStory.Queue;

public class StacksUsingQueues {

	Queue dq;
	Queue hq;

	public StacksUsingQueues(int cap) {
		dq = new Queue(cap);
		hq = new Queue(cap);
	}

	public int size() {
		return dq.size();
	}

	public boolean isFull() {
		return dq.isFull();
	}

	public boolean isEmpty() {
		return dq.isEmpty();
	}

	public void push(int val) {

		if (dq.isFull()) {
			System.out.println("Stack is full");
			return;
		}

		while (dq.size() > 0) {
			hq.enqueue(dq.dequeue());
		}
		dq.enqueue(val);

		while (hq.size() > 0) {
			dq.enqueue(hq.dequeue());
		}
	}
	
	public int pop() {
		if(dq.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return dq.dequeue();
	}
	
	public int top() {
		if(dq.isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return dq.front();
	}
	
	public void display() {
		dq.display();
	}
}
