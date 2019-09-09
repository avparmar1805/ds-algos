package QueueStory;

public class QueueTClient {
	
	public static void main(String [] args) {
		
		QueueT queueT = new QueueT(3);
		queueT.enqueue(2);
		queueT.enqueue(3);
		queueT.enqueue(4);

		queueT.dequeue();
		queueT.enqueue(14);
		queueT.dequeue();
		queueT.dequeue();
		queueT.dequeue();


		
	}

}
