package june14.adapters;

import june12.queues.DynamicQueue;

public class StackUsingQueuesPushEfficient {
	DynamicQueue dq;
	DynamicQueue hq;

	public StackUsingQueuesPushEfficient(int cap) {
		dq = new DynamicQueue(cap);
		hq = new DynamicQueue(cap);
	}

	public void push(int val) {
		dq.enqueue(val);
	}

	public int pop() {
		int rv = 0;

		while (dq.size() > 1) {
			hq.enqueue(dq.dequeue());
		}

		rv = dq.dequeue();

		DynamicQueue temp = hq;
		hq = dq;
		dq = temp;

		return rv;
	}

	public int top() {
		int rv = 0;

		while (dq.size() > 1) {
			hq.enqueue(dq.dequeue());
		}

		rv = dq.dequeue();
		hq.enqueue(rv);

		DynamicQueue temp = hq;
		hq = dq;
		dq = temp;

		return rv;
	}

	public int size() {
		return dq.size();
	}

	public boolean isEmpty() {
		return dq.isEmpty();
	}

	public void display() {
		// display reverse
	}
}
