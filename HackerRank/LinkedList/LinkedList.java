package LinkedList;

import java.util.HashSet;

import StackStory.Stack;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(int data) {

		if (this.size == 0) {
			this.handleAddWhenSize0(data);
		} else {
			Node node = new Node();
			node.data = data;
			node.next = null;

			tail.next = node;
			tail = node;
			this.size++;
		}

	}

	private void handleAddWhenSize0(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;

		this.head = this.tail = node;
		this.size++;
	}

	public void display() {
		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " => ");
			temp = temp.next;
		}
		System.out.println(".");
	}

	public void addFirst(int data) {
		if (this.size == 0) {
			this.handleAddWhenSize0(data);
		} else {
			// create
			Node node = new Node();
			node.data = data;
			node.next = this.head;

			// update summary
			head = node;
			this.size++;
		}
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		}
		return head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		}
		return tail.data;
	}

	public int getAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound");
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node.data;
	}

	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		} else if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bound");
		}

		Node node = head;
		for (int i = 0; i < idx; i++) {
			node = node.next;
		}
		return node;
	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of bound");
		} else if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size) {
			this.addLast(data);
		} else {
			Node idxm1Node = this.getNodeAt(idx - 1);
			Node idxNode = idxm1Node.next;

			Node node = new Node();
			node.data = data;
			node.next = idxNode;

			idxm1Node.next = node;
			this.size++;
		}
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		} else if (this.size == 1) {
			return this.handleRemovalWhenSizeIs1();
		} else {
			int temp = head.data;

			head = head.next;
			this.size--;
			return temp;
		}
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("List is empty");
		} else if (this.size == 1) {
			return this.handleRemovalWhenSizeIs1();
		} else {
			int temp = tail.data;
			Node secondLast = this.getNodeAt(this.size - 2);
			tail = secondLast;
			tail.next = null;
			this.size--;

			return temp;
		}
	}

	private int handleRemovalWhenSizeIs1() {
		int temp = head.data;
		head = tail = null;
		this.size--;
		return temp;
	}

	public int removeAt(int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Index out of bound");
		} else if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size) {
			return this.removeLast();
		} else {
			Node idxm1Node = this.getNodeAt(idx - 1);
			Node idxNode = idxm1Node.next;
			Node idxP1Node = idxNode.next;
			idxm1Node.next = idxP1Node;

			this.size--;
			return idxNode.data;
		}
	}

	public void displayReverse() {
		displayReverseHelper(head);
	}

	private void displayReverseHelper(Node node) {
		if (node == null) {
			return;
		}
		displayReverseHelper(node.next);
		System.out.print(node.data + " => ");
	}

	public void reversePointerIteratively() {
		Node prev = head;
		Node curr = head.next;

		while (curr != null) {
			Node next = curr.next;

			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	public void reversePointerRecursively() {
		reversePointerRecursivelyHelper(head);
		Node temp = tail;
		tail = head;
		head = temp;
		tail.next = null;
	}

	public void reversePointerRecursivelyHelper(Node curr) {
		if (curr == tail) {
			return;
		}

		reversePointerRecursivelyHelper(curr.next);
		curr.next.next = curr;
	}

	private class HeapMover {
		Node node;
	}

	public void reverseDataRecursive() {
		HeapMover left = new HeapMover();
		left.node = head;
		reverseDataRecursiveHelper(left, head, 0);
	}

	public void reverseDataRecursiveHelper(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverseDataRecursiveHelper(left, right.next, floor + 1);
		if (floor >= size / 2) {
			int tempData = right.data;
			right.data = left.node.data;
			left.node.data = tempData;
			left.node = left.node.next;
		}
	}

	public boolean isPalindrome() {
		HeapMover left = new HeapMover();
		left.node = head;
		return isPalindrome(left, head);
	}

	private boolean isPalindrome(HeapMover left, Node right) {

		if (right == null) {
			return true;
		}

		boolean isPalin = isPalindrome(left, right.next);
		if (isPalin == false) {
			return false;
		} else {
			if (left.node.data == right.data) {
				left.node = left.node.next;
				return true;
			} else {
				return false;
			}
		}
	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = head;
		fold(left, head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		fold(left, right.next, floor + 1);

		if (floor > this.size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		} else if (floor == this.size / 2) {
			tail = right;
			tail.next = null;
		}
	}

	public int kthFromLast(int k) {
		Node si = head;
		Node li = head;

		for (int i = 0; i < k; i++) {
			li = li.next;
		}

		while (li != null) {
			si = si.next;
			li = li.next;
		}

		return si.data;
	}

	public int mid() {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public Node midNode() {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static LinkedList merge2SortedLL(LinkedList one, LinkedList two) {
		LinkedList res = new LinkedList();
		Node oneCounter = one.head;
		Node twoCounter = two.head;

		while (oneCounter != null && twoCounter != null) {
			if (oneCounter.data <= twoCounter.data) {
				res.addLast(oneCounter.data);
				oneCounter = oneCounter.next;
			} else {
				res.addLast(twoCounter.data);
				twoCounter = twoCounter.next;
			}
		}
		while (oneCounter != null) {
			res.addLast(oneCounter.data);
			oneCounter = oneCounter.next;
		}
		while (twoCounter != null) {
			res.addLast(twoCounter.data);
			twoCounter = twoCounter.next;
		}

		return res;
	}

	public static LinkedList mergeSortLL(LinkedList list) {
		if (list.head == list.tail) {
			return list;
		}
		Node mid = list.midNode();

		LinkedList fh = new LinkedList();
		fh.head = list.head;
		fh.tail = mid;
		fh.size = (list.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = mid.next;
		sh.tail = list.tail;
		fh.size = list.size / 2;
		mid.next = null;

		fh = LinkedList.mergeSortLL(fh);
		sh = LinkedList.mergeSortLL(sh);

		LinkedList res = LinkedList.merge2SortedLL(fh, sh);
		return res;
	}

	public void oddEven() throws Exception {
		LinkedList odd = new LinkedList();
		LinkedList even = new LinkedList();

		while (this.size != 0) {
			int data = this.removeFirst();

			if (data % 2 == 0) {
				even.addLast(data);
			} else {
				odd.addLast(data);
			}
		}

		if (odd.size == 0) {
			this.head = even.head;
			this.tail = even.tail;
			this.size = even.size;
		} else if (even.size == 0) {
			this.head = odd.head;
			this.tail = odd.tail;
			this.size = odd.size;
		} else {
			this.head = odd.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;

			odd.tail.next = even.head;
		}
	}

	public void removeDuplicates() throws Exception {
		LinkedList uniLL = new LinkedList();

		while (this.size != 0) {
			int data = this.removeFirst();
			if (uniLL.size == 0 || uniLL.tail.data != data) {
				uniLL.addLast(data);
			}
		}
		this.head = uniLL.head;
		this.tail = uniLL.tail;
		this.size = uniLL.size;
	}

	public void kthReverse(int k) throws Exception {
		LinkedList newList = new LinkedList();
		LinkedList temp = new LinkedList();

		while (this.size != 0) {

			for (int i = 0; i < k; i++) {
				int data = this.removeFirst();
				temp.addFirst(data);
			}
			if (newList.size == 0) {
				newList = temp;
			} else {
				newList.tail.next = temp.head;
				newList.tail = temp.tail;
				newList.size += temp.size;
			}
			temp = new LinkedList();
		}
		this.head = newList.head;
		this.tail = newList.tail;
	}

	public boolean isCyclic() {
		boolean isCyclic = false;

		Node fast = this.head;
		Node slow = this.head;

		while (fast != null && fast.next != null && slow != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (fast == slow) {
				return true;
			}
		}

		return isCyclic;
	}

	public void removeDuplicatesUsingHM() {
		Node curr = this.head;
		Node prev = null;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		while (curr.next != null) {
			int currVal = curr.data;

			if (hashSet.contains(currVal)) {
				prev.next = curr.next;
			} else {
				hashSet.add(currVal);
				prev = curr;
			}

			curr = curr.next;
		}
	}

	public static void add2LL(LinkedList one, LinkedList two) {
		Stack st = new Stack(one.size + 1);
		int carry = add2LLHelper(one.head, two.head, st);
		if (carry > 0) {
			st.push(carry);
		}
		st.display();
	}

	private static int add2LLHelper(Node oneNode, Node twoNode, Stack st) {

		if (oneNode == null || twoNode == null) {
			return 0;
		}
		int carry = add2LLHelper(oneNode.next, twoNode.next, st);
		int currVal = carry + oneNode.data + twoNode.data;
		st.push(currVal % 10);

		return currVal / 10;
	}
}
