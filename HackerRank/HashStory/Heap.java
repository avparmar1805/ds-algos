package HashStory;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean _isMin;

	public Heap(boolean isMin) {
		_isMin = isMin;
	}

	public int peek() {
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	public void add(int value) {
		data.add(value);
		upheapify(data.size() - 1);
	}

	public int remove() {
		swap(0, data.size() - 1);
		int val = data.remove(data.size() - 1);
		downHeapify(0);
		return val;
	}

	private void downHeapify(int pi) {

		int li = 2 * pi + 1;
		int ri = 2 * pi + 2;

		int max = pi;
		
		if(li < data.size() && isHP(li, max) > 0) {
			max = li;
		}
		
		if(ri < data.size() && isHP(ri, max) > 0) {
			max = ri;
		}
		
		if(max != pi) {
			swap(max, pi);
			downHeapify(max);
		}
	}

	private void upheapify(int ci) {
		if (ci == 0) {
			return;
		}

		int pi = (ci - 1) / 2;

		if (isHP(ci, pi) > 0) {
			swap(ci, pi);
			upheapify(pi);
		}
	}

	private int isHP(int i, int j) {
		if (_isMin) {
			return (data.get(i) - data.get(j)) * -1;
		} else {
			return data.get(i) - data.get(j);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
}
