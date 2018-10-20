package june12.queues;

public class Client {

	public static void main(String[] args) {
		Queue qu = new DynamicQueue(5);
		qu.enqueue(10);
		qu.enqueue(20);
		qu.enqueue(30);
		qu.enqueue(40);
		qu.enqueue(50);
		qu.dequeue();
		qu.dequeue();
		qu.enqueue(60);
		qu.enqueue(70);
		qu.display();
		qu.enqueue(80);
		qu.display();
	}

}
