package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KMaxSumCombinations {

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(new Integer[] { 4, 2, 5, 1 }));

		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(new Integer[] { 8, 0, 3, 5 }));

		class Pair {

			int index1;
			int index2;

			Pair(int index1, int index2) {
				this.index1 = index1;
				this.index2 = index2;
			}
		}

		class QueueElement {

			int val;
			Pair pair;

			QueueElement(int val, int index1, int index2) {
				this.pair = new Pair(index1, index2);
				this.val = val;
			}

		}
		int n = A.size();
		ArrayList<Integer> result = new ArrayList<>();
		Collections.sort(A, (x, y) -> y - x);
		Collections.sort(B, (x, y) -> y - x);

		PriorityQueue<QueueElement> pq = new PriorityQueue<>((x,y) -> y.val - x.val);

		Set<Pair> set = new HashSet<Pair>();
		int ptr1 = 0;
		int ptr2 = 0;
		int count = 0;
		set.add(new Pair(0, 0));

		pq.add(new QueueElement(A.get(ptr1) + B.get(ptr2), ptr1, ptr2));

		while (count < n) {
			QueueElement el = pq.poll();
			result.add(el.val);
			ptr1 = el.pair.index1;
			ptr2 = el.pair.index2;

			if (!set.contains(new Pair(ptr1, ptr2 + 1)) && ptr2 + 1 != n) {
				set.add(new Pair(ptr1, ptr2 + 1));
				pq.add(new QueueElement(A.get(ptr1) + B.get(ptr2 + 1), ptr1, ptr2 + 1));
			}
			if (!set.contains(new Pair(ptr1 + 1, ptr2)) && ptr1 + 1 != n) {
				set.add(new Pair(ptr1 + 1, ptr2));
				pq.add(new QueueElement(A.get(ptr1 + 1) + B.get(ptr2), ptr1 + 1, ptr2));
			}

			count++;
		}
	}

}
