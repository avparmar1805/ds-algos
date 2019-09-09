package LRU;

import java.util.HashMap;

public class LRUCache {

	private HashMap<Integer, Node> hMap = new HashMap();
	private int capacity, count;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		count = 0;
	}

	public void deleteNode(Node node) {
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}

	public void addToHead(Node node) {
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
	}

	public int get(int key) {
		if (hMap.get(key) != null) {
			Node node = hMap.get(key);
			int retVal = node.value;
			deleteNode(node);
			addToHead(node);
			return retVal;
		}

		return -1;
	}

	public void set(int key, int value) {
		if (hMap.get(key) != null) {
			Node node = hMap.get(key);
			node.value = value;
			deleteNode(node);
			addToHead(node);
		} else {
			Node node = new Node(key, value);
			hMap.put(key, node);

			if (count < capacity) {
				count++;
				addToHead(node);
			} else {
				hMap.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}
}
