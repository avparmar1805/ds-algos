package QueueStory;

public class QueueT {

	private int front;
	private int size;
	private int arr[];

	public QueueT(int n) {
		arr = new int[n];
	}

	public void enqueue(int val) {
		int rear = (front + size) % arr.length;
		arr[rear] = val;
		size++;
	}

	public int dequeue() {

		int val = arr[front];
		arr[front] = 0;
		this.front = (front + 1) % arr.length;
		size--;
		System.out.println("Dequeued " + val);
		return val;
	}

}
