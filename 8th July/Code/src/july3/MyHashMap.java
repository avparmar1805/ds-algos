package july3;

import java.util.ArrayList;

import june15.GenericLinkedList;

public class MyHashMap<K, V> {
	private class HMNode {
		K key;
		V value;
	}
	
	GenericLinkedList<HMNode>[] buckets; // N
	int size; // n
	
	public MyHashMap(){
		buckets = new GenericLinkedList[4];
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new GenericLinkedList<>();
		}
		
		size = 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public void display(){
		System.out.println("-----------------------------");
		for(int bidx = 0; bidx < buckets.length; bidx++){
			System.out.print("B" + bidx + " -> ");
			for(int didx = 0; didx < buckets[bidx].size(); didx++){
				HMNode n2p = buckets[bidx].getAt(didx);
				System.out.print("[" + n2p.value + "@" + n2p.key + "], ");
			}
			System.out.println(".");
		}
		System.out.println("-----------------------------");
	}
	
	public boolean containsKey(K key){
		int bidx = hashFn(key);
		int didx = findInBucket(bidx, key);
		
		if(didx == -1){
			return false;
		} else {
			return true;
		}
	}
	
	public V get(K key){
		int bidx = hashFn(key);
		int didx = findInBucket(bidx, key);
		
		if(didx == -1){
			return null;
		} else {
			HMNode n2r = buckets[bidx].getAt(didx);
			return n2r.value;
		}
	}
	
	public V remove(K key){
		int bidx = hashFn(key);
		int didx = findInBucket(bidx, key);
		
		if(didx == -1){
			return null;
		} else {
			HMNode n2r = buckets[bidx].removeAt(didx);
			this.size--;
			return n2r.value;
		}
	}
	
	public void put(K key, V value){
		int bidx = hashFn(key);
		int didx = findInBucket(bidx, key);
		
		if(didx == -1){
			HMNode n2add = new HMNode();
			n2add.key = key;
			n2add.value = value;
			buckets[bidx].addLast(n2add);
			this.size++;
		} else {
			HMNode n2u = buckets[bidx].getAt(didx);
			n2u.value = value;
		}
		
		double lambda = this.size * 1.0 / buckets.length;
		if(lambda > 2.0){
			rehash();
		}
	}
	
	public ArrayList<K> keyset(){
		ArrayList<K> keys = new ArrayList<>();
		
		for(int bidx = 0; bidx < buckets.length; bidx++){
			for(int didx = 0; didx < buckets[bidx].size(); didx++){
				HMNode n2p = buckets[bidx].getAt(didx);
				keys.add(n2p.key);
			}
		}
		
		return keys;
	}
	
	// bucket index against key
	private int hashFn(K key){
		return Math.abs(key.hashCode()) % buckets.length;
	}
	
	// finds the key in the bucket
	private int findInBucket(int bidx, K key){
		for(int i = 0; i < buckets[bidx].size(); i++){
			if(buckets[bidx].getAt(i).key.equals(key)){ // == likhne wala gadha
				return i;
			}
		}
		
		return -1;
	}
	
	private void rehash(){
		GenericLinkedList<HMNode>[] obuckets = buckets;
		
		buckets = new GenericLinkedList[obuckets.length * 2];
		for(int i = 0; i < buckets.length; i++){
			buckets[i] = new GenericLinkedList<>();
		}
		size = 0;
		
		for(int bidx = 0; bidx < obuckets.length; bidx++){
			for(int didx = 0; didx < obuckets[bidx].size(); didx++){
				HMNode n2add = obuckets[bidx].getAt(didx);
				put(n2add.key, n2add.value);
			}
		}
	}
}
