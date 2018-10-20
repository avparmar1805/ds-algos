package june28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class mergeKLists {

	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
//		lists.add(new ArrayList<>(Arrays.asList(10, 15, 20, 25)));
//		lists.add(new ArrayList<>(Arrays.asList(5, 7, 12, 18, 22)));
//		lists.add(new ArrayList<>(Arrays.asList(3, 14, 19, 23, 34)));
//		lists.add(new ArrayList<>(Arrays.asList(11, 17, 21)));
//		mergelists(lists);
		
		int[] arr = {11, 3, 7, 15, 25, 20, 55, 66, 30};
		sortAlmostSortedArray(arr, 2);
	}

	public static void mergelists(ArrayList<ArrayList<Integer>> lists) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();

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

	private static void sortAlmostSortedArray(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i <= k; i++){
			pq.add(arr[i]);
		}
		
		int i = k + 1;
		while(pq.size() > 0){
			System.out.print(pq.remove() + " ");
			if(i < arr.length){
				pq.add(arr[i]);
				i++;
			}
		}
	}
}
