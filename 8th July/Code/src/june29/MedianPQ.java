package june29;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPQ {
	private PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> larger = new PriorityQueue<>();
	int size = 0;
	
	public void add(int data){
		if(larger.size() != 0 && data > larger.peek()){
			larger.add(data);
		} else if(smaller.size() != 0 && data < smaller.peek()){
			smaller.add(data);
		} else {
			smaller.add(data);
		}
		
		if(larger.size() - smaller.size() == 2){
			smaller.add(larger.remove());
		} else if(smaller.size() - larger.size() == 2){
			larger.add(smaller.remove());
		}
		size++;
	}
	
	public int remove(){
		if(size == 0){
			return -1;
		}
		
		size--;
		if(smaller.size() >= larger.size()){
			return smaller.remove();
		} else {
			return larger.remove();
		}
	}
	
	public int peek(){
		if(size == 0){
			return -1;
		}
		
		if(smaller.size() >= larger.size()){
			return smaller.peek();
		} else {
			return larger.peek();
		}
	}
}
