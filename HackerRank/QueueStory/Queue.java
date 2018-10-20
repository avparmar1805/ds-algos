package QueueStory;

public class Queue {
	protected int[] data;
	protected int front = 0;
	private int size = 0;

	public Queue(int cap) {
		this.data = new int[cap];
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == data.length;
	}

	public void enqueue(int val) {
		if (!isFull()) {
			int rear = (this.front + this.size) % data.length;
			data[rear] = val;
			this.size++;
		} else {
			System.out.println("Queue is full");
		}
	}

	public int dequeue() {
		int retVal = -1;
		if (!isEmpty()) {
			retVal = data[this.front];
			data[this.front] = 0;
			this.front = (front + 1) % data.length;
			this.size--;
		} else {
			System.out.println("Queue is empty");
		}

		return retVal;
	}

	public int front() {
		return data[this.front];
	}

	public void display() {
		for (int i = 0; i < this.size; i++) {
			System.out.print(data[(front + i) % data.length] + " ");
		}
		System.out.println();
	}
}
