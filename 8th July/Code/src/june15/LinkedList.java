package june15;

public class LinkedList {
	
	private class Node {
		int data;
		Node next;
	}

	// data hiding
	private Node head;
	private Node tail;
	private int size;

	public void addLast(int data) {
		if (this.size == 0) {
			this.handleAddWhenSize0(data);
		} else {
			// create node
			Node node = new Node();
			// set data
			node.data = data;
			// connect
			tail.next = node;
			// update summary
			tail = node;
			size++;
		}
	}

	// abstraction
	private void handleAddWhenSize0(int data) {
		// create node
		Node node = new Node();
		// set data
		node.data = data;
		// update summary
		head = node;
		tail = node;
		size++;

	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		for (Node node = this.head; node != null; node = node.next) {
			System.out.print(node.data + " -> ");
		}
		System.out.println(".");
	}

	public void addFirst(int data) {
		if (this.size == 0) {
			this.handleAddWhenSize0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = head;
			head = node;
			size++;
		}
	}

	public int getFirst() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		}
		return head.data;
	}

	public int getLast() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		}
		return tail.data;
	}

	public int getAt(int idx) {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return -1;
		}

		Node rv = head;

		for (int i = 0; i < idx; i++) {
			rv = rv.next;
		}

		return rv.data;
	}

	// abstraction
	private Node getNodeAt(int idx) {
		if (this.size == 0) {
			System.out.println("List is empty");
			return null;
		} else if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return null;
		}

		Node rv = head;

		for (int i = 0; i < idx; i++) {
			rv = rv.next;
		}

		return rv;
	}

	public void addAt(int data, int idx) {
		if (idx < 0 || idx > size) {
			System.out.println("Index out of bounds");
			return;
		} else if (idx == 0) {
			this.addFirst(data);
		} else if (idx == size) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node np1 = nm1.next;

			Node node = new Node();
			node.data = data;

			nm1.next = node;
			node.next = np1;
			size++;
		}
	}

	public int removeFirst() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (this.size == 1) {
			return this.handleRemoveWhenSizeis1();
		}

		Node first = head;
		Node second = first.next;

		head = second;
		size--;

		return first.data;
	}

	public int removeLast() {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (this.size == 1) {
			return this.handleRemoveWhenSizeis1();
		}

		Node last = tail;
		Node secondLast = this.getNodeAt(size - 2);

		tail = secondLast;
		secondLast.next = null;
		size--;

		return last.data;
	}

	private int handleRemoveWhenSizeis1() {
		Node node = head;

		head = tail = null;
		size = 0;

		return node.data;
	}

	public int removeAt(int idx) {
		if (this.size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (idx < 0 || idx >= this.size) {
			System.out.println("Index out of bound");
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			size--;

			return n.data;
		}
	}

	public void reverseDataIterative() {
		int left = 0;
		int right = size - 1;
		while (left < right) {
			Node leftnode = this.getNodeAt(left);
			Node rightnode = this.getNodeAt(right);

			int temp = leftnode.data;
			leftnode.data = rightnode.data;
			rightnode.data = temp;

			left++;
			right--;
		}
	}

	public void reversePointerIterative() {
		Node prev = head;
		Node curr = prev.next;

		while (curr != null) {
			Node ocn = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ocn;
		}

		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	public void reversePointerRecursive() {
		reversePointerRecursiveHelper(head);
		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;
	}

	private void reversePointerRecursiveHelper(Node prev) {
		if (prev == tail) {
			return;
		}
		reversePointerRecursiveHelper(prev.next);
		prev.next.next = prev;
	}

	private class HeapMover {
		Node node;
	}

	public void reverseDataRecursive() {
		HeapMover mover = new HeapMover();
		mover.node = head;
		reverseDataRecursive(mover, head, 0);
	}

	private void reverseDataRecursive(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursive(left, right.next, floor + 1);

		if (floor >= size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;

			left.node = left.node.next;
		}
	}
	
	public boolean IsPalindrome(){
		HeapMover mover = new HeapMover();
		mover.node = head;
		return IsPalindrome(mover, head);
	}
	
	private boolean IsPalindrome(HeapMover left, Node right){
		if(right == null){
			return true;
		}
		boolean rres = IsPalindrome(left, right.next);
		
		if(rres == false){
			return false;
		} else {
			if(left.node.data == right.data){
				left.node = left.node.next;
				return true;
			} else {
				return false;
			}
		}
	}

	public void fold(){
		HeapMover mover = new HeapMover();
		mover.node = head;
		fold(mover, head, 0);
	}
	
	private void fold(HeapMover left, Node right, int floor){
		if(right == null){
			return;
		}
		
		fold(left, right.next, floor + 1);

		if(floor > size / 2){
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		} else if(floor == size / 2){
			tail = right;
			tail.next = null;
		}
	}

	public int kthFromLast(int k){
		Node fast = head;
		for(int i = 0; i < k; i++){
			fast = fast.next;
		}
		
		Node slow = head;
		while(fast != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}
	
	public int mid(){
		Node fast = head;
		Node slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data;
	}

	public void kreverse(int k){
		LinkedList prev = new LinkedList();
		LinkedList curr = new LinkedList();
		
		while(this.size() > 0){
			for(int i = 0; i < k; i++){
				curr.addFirst(this.removeFirst());
			}
			
			
			if(prev.size == 0){
				prev = curr;
				curr = new LinkedList();
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
				
				curr = new LinkedList();
			}
		}
		
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	public void removeDuplicates(){
//		LinkedList list = new LinkedList();
//		
//		while(this.size != 0){
//			int data = this.removeFirst();
//			
//			if(list.size == 0 || list.tail.data != data){
//				list.addLast(data);
//			}
//		}
//		
//		this.head = list.head;
//		this.tail = list.tail;
//		this.size = list.size;
		
		Node curr = head;
		Node prev = head;
		int counter = 0;
		
		while(prev != null){
			while(prev.next != null && prev.data == prev.next.data){
				prev = prev.next;
			}
			
			curr.next = prev.next;
			counter++;
			
			prev = prev.next;
			if(prev == null){
				this.tail = curr;
			} else {
				curr = curr.next;
			}
		}
		
		this.size = counter;
	}

	public static LinkedList merge(LinkedList one, LinkedList two){
		LinkedList list = new LinkedList();
		Node optr = one.head;
		Node tptr = two.head;
		
		while(optr != null && tptr != null){
			if(optr.data < tptr.data){
				list.addLast(optr.data);
				optr = optr.next;
			} else {
				list.addLast(tptr.data);
				tptr = tptr.next;
			}
		}
		
		while(optr != null){
			list.addLast(optr.data);
			optr = optr.next;
		}
		
		while(tptr != null){
			list.addLast(tptr.data);
			tptr = tptr.next;
		}
		
		return list;
	}

	private Node midNode(){
		Node fast = head;
		Node slow = head;
		
		while(fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}

	public static LinkedList mergesort(LinkedList list){
		if(list.head == list.tail){
			return list;
		}
		
		Node mid = list.midNode();
		
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.head = list.head;
		l1.tail = mid;
		
		l2.head = mid.next;
		l2.tail = list.tail;
		
		l1.tail.next = null;
		
		l1 = mergesort(l1);
		l2 = mergesort(l2);
		
		LinkedList l3 = merge(l1, l2);
		l3.size = list.size;
		
		return l3;
	}
	
	public void placeOddEven(){
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();
		
		while(this.size() > 0){
			int data = this.removeFirst();
			
			if(data % 2 == 1){
				odd.addLast(data);
			} else {
				even.addLast(data);
			}
		}
		
		if(odd.size() == 0){
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		} else if(even.size == 0){
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			odd.tail.next = even.head;
			odd.size += even.size;
			
			this.head = odd.head;
			this.tail = even.tail;
			this.size = odd.size;
		}
	}
}
