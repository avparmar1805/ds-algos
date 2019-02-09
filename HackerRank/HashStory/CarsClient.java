package HashStory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class CarsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Car[] cars = new Car[5];
//		cars[0] = new Car(100, 10, "A");
//		cars[1] = new Car(200, 20, "B");
//		cars[2] = new Car(300, 30, "C");
//		cars[3] = new Car(400, 40, "D");
//		cars[4] = new Car(500, 50, "E");
//		Arrays.sort(cars);
//		
//		for(Car val: cars) {
//			val.display();
//		}

		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
		al.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
		al.add(new ArrayList<>(Arrays.asList(5, 15, 25, 35, 45)));
		al.add(new ArrayList<>(Arrays.asList(13, 14, 23, 33, 43)));
		al.add(new ArrayList<>(Arrays.asList(11, 24, 32, 41, 46)));

		PriorityQueue<Node> mPq = new PriorityQueue<Node>();

		for (int i = 0; i < al.size(); i++) {
			Node node = new Node(i, 0, al.get(i).get(0));
			mPq.add(node);
		}

		while (mPq.size() > 0) {
			Node node = mPq.remove();
			System.out.println(node.val + " ");
			node.listNo++;
			//if(node.indexNo < )
		}
	}

	public static class Car implements Comparable<Car> {

		public int speed;
		public int price;
		public String name;

		public Car(int speed, int price, String name) {
			this.speed = speed;
			this.name = name;
			this.price = price;
		}

		public void display() {
			System.out.println(this.price + " " + this.speed + " " + this.name);
		}

		public int compareTo(Car o) {
			return this.speed - o.speed;
		}

	}

	public static class Node implements Comparable<Node>{
		int listNo;
		int indexNo;
		int val;

		public Node(int listNo, int indexNo, int val) {
			this.listNo = listNo;
			this.indexNo = indexNo;
			this.val = val;
		}

		
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
		
	}


}
