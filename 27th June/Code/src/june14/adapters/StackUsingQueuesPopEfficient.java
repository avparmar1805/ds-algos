package june14.adapters;

import june12.queues.DynamicQueue;

public class StackUsingQueuesPopEfficient {
	DynamicQueue dq;
	DynamicQueue hq;

	public StackUsingQueuesPopEfficient(int cap) {
		dq = new DynamicQueue(cap);
		hq = new DynamicQueue(cap);
	}

	public void push(int val) {
		while(dq.size() > 0){
			hq.enqueue(dq.dequeue());
		}
		
		dq.enqueue(val);
		
		while(hq.size() > 0){
			dq.enqueue(hq.dequeue());
		}
	}

	public int pop() {
		return dq.dequeue();
	}

	public int top() {
		return dq.front();
	}

	public int size() {
		return dq.size();
	}

	public boolean isEmpty() {
		return dq.isEmpty();
	}

	public void display() {
		dq.display();
	}
}
