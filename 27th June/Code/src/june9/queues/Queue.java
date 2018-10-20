package june9.queues;

public class Queue {
	private int[] data;
	private int front;
	private int size;
	
	public Queue(int cap){
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public int front(){
		if(this.size == 0){
			System.out.println("Queue is empty");
			return -1;
		}
		int rv = data[front];
		return rv;
	}
	
	public void enqueue(int val){
		if(this.size == data.length){
			System.out.println("Queue is full");
			return;
		}
		
		int rear = (front + size) % data.length; // circular
		data[rear] = val;
		size++;
	}
	
	public int dequeue(){
		if(this.size == 0){
			System.out.println("Queue is empty");
			return -1;
		}
		
		int rv = data[front];
		
		data[front] = 0;
		front = (front + 1) % data.length;
		size--;
		
		return rv;
	}

	public void display(){
		for(int i = 0; i < size; i++){
			System.out.print(data[(front + i) % data.length]);
		}
		System.out.println(".");
	}
}
