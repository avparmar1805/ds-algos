package HashStory;

import java.util.Collections;
import java.util.PriorityQueue;

public class ClientPQ {
	public static void main(String[] args) {
		// int[] arr = { 10, 1, 7, 23, 42, 37, 8 };
		// printKSmallest(arr, 3);

		// MedianPriorityQueue mpq = new MedianPriorityQueue();
		// mpq.add(10);
		// mpq.add(50);
		// mpq.add(30);
		// System.out.println(mpq.peek());
		// mpq.add(40);
		// mpq.add(70);
		// System.out.println(mpq.peek());
		// mpq.add(90);
		// mpq.add(100);
		// System.out.println(mpq.remove());
		// mpq.add(45);
		// System.out.println(mpq.peek());
		// System.out.println(mpq.remove());
		// mpq.add(75);
		// System.out.println(mpq.remove());
		// System.out.println(mpq.remove());

		int[] arr = { 30, 20, 10, 60, 50, 40, 80, 70 };
		KSorted(arr, 2);
	}

	public static void KSorted(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i <= k; i++) {
			pq.add(arr[i]);
		}
		for (int i = k + 1; i < arr.length; i++) {
			System.out.println(pq.remove());
			pq.add(arr[i]);
		}
		while (pq.size() > 0) {
			System.out.println(pq.remove());
		}
	}

	public static void printKSmallest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int counter = k;
		while (counter > 0) {
			System.out.println(pq.remove());
			counter--;
		}

		System.out.println("-------------");

		PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < k; i++) {
			pq1.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			if (arr[i] < pq1.peek()) {
				pq1.remove();
				pq1.add(arr[i]);
			}
		}

		while (k > 0) {
			System.out.println(pq1.remove());
			k--;
		}
	}
}
