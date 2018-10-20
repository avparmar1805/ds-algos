package june28;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
		// int[] arr = {41, 35, 68, 9, 11};
		// Arrays.sort(arr);
		//
		// for(int val: arr){
		// System.out.println(val);
		// }
		// Car[] cars = new Car[5];
		// cars[0] = new Car(100, 1000, "BMW");
		// cars[1] = new Car(200, 1500, "Merc");
		// cars[2] = new Car(80, 1100, "ABC");
		// cars[3] = new Car(150, 900, "DEF");
		// cars[4] = new Car(70, 1600, "GHI");
		//
		// Arrays.sort(cars);
		//
		// for(Car car: cars){
		// System.out.println(car);
		// }

		int[] arr = { 15, 5, 17, 20, 3, 44, 6, 11 };
		int k = 3;

		ksmallest(arr, k);
	}
	
	private static void ksmallest(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < k; i++){
			pq.add(arr[i]);
		}
		
		for(int i = k; i < arr.length; i++){
			if(arr[i] < pq.peek()){
				pq.remove();
				pq.add(arr[i]);
			}
		}
		
		System.out.println(pq);
	}

	private static class Car implements Comparable<Car> {
		int speed;
		int price;
		String name;

		Car(int speed, int price, String name) {
			this.speed = speed;
			this.price = price;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Speed = " + this.speed + ", Price = " + this.price + ", Name = " + this.name;
		}

		@Override
		public int compareTo(Car o) {
			return o.price - this.price;
		}
	}

}
