package july2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Client {

	public static void main(String[] args) {
//		int[] arr = {2, 5, 9, 1, 0, 8, 7, 6};
//		Heap pq = new Heap();
//		for(int val: arr){
//			pq.add(val);
//		}
//		while(pq.size() > 0){
//			System.out.print(pq.remove() + " ");
//		}
		
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		lists.add(new ArrayList<>(Arrays.asList(10, 15, 20, 25)));
//		lists.add(new ArrayList<>(Arrays.asList(5, 7, 12, 18, 22)));
//		lists.add(new ArrayList<>(Arrays.asList(3, 14, 19, 23, 34)));
//		lists.add(new ArrayList<>(Arrays.asList(11, 17, 21)));
//		mergelists(lists);
		
//		GenericHeap<String> heap = new GenericHeap<>(true);
//		heap.add("hi");
//		heap.add("bye");
//		heap.add("hello");
//		heap.add("there");
//		heap.add("world");
//		heap.add("random");
//		
//		while(heap.size() > 0){
//			System.out.println(heap.remove());
//		}
		int[] arr = {2, 8, 1, 5, 4, 3, 0};
		heapSort(arr);
		for(int val: arr){
			System.out.print(val + " ");
		}
		System.out.println(".");
	}

	public static void heapSort(int[] arr){
		for(int i = arr.length - 1; i >= 0; i--){
			downheapify(arr, arr.length, i);
		}
		
		for(int i = arr.length - 1; i > 0; i--){
			swap(arr, i, 0);
			downheapify(arr, i, 0);
		}
	}
	
	private static void downheapify(int[] arr, int ep, int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int mini = pi;
		if(lci < ep && arr[lci] > arr[mini]){
			mini = lci;
		}
		
		if(rci < ep && arr[rci] > arr[mini]){
			mini = rci;
		}
		
		if(mini != pi){
			swap(arr, pi, mini);
			downheapify(arr, ep, mini);
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void mergelists(ArrayList<ArrayList<Integer>> lists) {
		GenericHeap<Pair> pq = new GenericHeap<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair(lists.get(i).get(0), i, 0);
			pq.add(p);
		}

		while (pq.size() > 0) {
			Pair p = pq.remove();
			System.out.print(p.val + " ");

			p.didx++;
			if (p.didx < lists.get(p.lidx).size()) {
				p.val = lists.get(p.lidx).get(p.didx);
				pq.add(p);
			}
		}
		System.out.println(".");
	}

	private static class Pair implements Comparable<Pair> {
		int val;
		int lidx;
		int didx;

		Pair(int val, int lidx, int didx) {
			this.val = val;
			this.lidx = lidx;
			this.didx = didx;
		}

		@Override
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}

}
