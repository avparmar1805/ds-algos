package HashStory;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {

	PriorityQueue<Integer> minln = new PriorityQueue<Integer>(); // larger
	PriorityQueue<Integer> maxsn = new PriorityQueue<Integer>(Collections.reverseOrder()); // smaller
	int size = 0;

	public void add(int data) {
		if (maxsn.size() != 0 && data < maxsn.peek()) {
			maxsn.add(data);
		} else if (minln.size() != 0 && data > minln.peek()) {
			minln.add(data);
		} else {
			maxsn.add(data);
		}
		size++;
		if(maxsn.size() - minln.size() == 2) {
			minln.add(maxsn.remove());
		} else if(minln.size() - maxsn.size() == 2){
			maxsn.add(minln.remove());
		}
	}

	public int remove() {
		if (size == 0) {
			System.out.println("Q is empty");
			return -1;
		}
		size--;
		return maxsn.size() >= minln.size() ? maxsn.remove() : minln.remove();
	}

	public int peek() {

		if (size == 0) {
			System.out.println("Q is empty");
			return -1;
		}

		return maxsn.size() >= minln.size() ? maxsn.peek() : minln.peek();
	}
}
