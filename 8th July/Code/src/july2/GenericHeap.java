package july2;

import java.util.ArrayList;

public class GenericHeap<T extends Comparable<T>> {
	private ArrayList<T> list = new ArrayList<>();
	private boolean rev = false;
	
	public GenericHeap(){
	}
	
	public GenericHeap(boolean rev){
		this.rev = rev;
	}
	
	public int size(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return this.list.isEmpty();
	}
	
	public void display(){
		System.out.println(list);
	}
	
	public void add(T val){
		list.add(val);
		upheapify(list.size() - 1);
	}
	
	private void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if(myCompareTo(pi, ci) > 0){
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public T peek(){
		return list.get(0);
	}
	
	public T remove(){
		swap(0, list.size() - 1);
		T rv = list.remove(list.size() - 1);
		downheapify(0);
		return rv;
	}
	
	private void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		
		int mini = pi;
		if(lci < list.size() && myCompareTo(lci, mini) < 0){
			mini = lci;
		}
		
		if(rci < list.size() && myCompareTo(rci, mini) < 0){
			mini = rci;
		}
		
		if(mini != pi){
			swap(mini, pi);
			downheapify(mini);
		}
	}

	private void swap(int i, int j) {
		T ith = list.get(i);
		T jth = list.get(j);
		list.set(i, jth);
		list.set(j, ith);
	}

	private int myCompareTo(int i, int j){
		T ith = list.get(i);
		T jth = list.get(j);
		
		if(rev == false){
			return ith.compareTo(jth);
		} else {
			return -1 * ith.compareTo(jth);
		}
	}

	public void updatePriority(T val){
		int idx = -1;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equals(val)){
				idx = i;
				break;
			}
		}
		
		upheapify(idx);
		downheapify(idx);
	}
}
