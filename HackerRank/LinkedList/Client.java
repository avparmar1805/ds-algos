package LinkedList;

public class Client {
	public static void main(String[] args) throws Exception {
		LinkedList list = new LinkedList();
		
		list.addLast(0);
		list.addLast(0);
		list.addLast(0);
		list.addLast(1);
		list.addLast(1);
		list.addLast(0);
		list.addLast(0);
		list.addLast(1);
		list.addLast(0);
//		list.addLast(8);
//		list.addLast(9);
		list.display();
		int sum = list.decimalValue();
		System.out.println(sum);
//		list.removeDuplicatesUsingHM();
//		list.display();
		// list.removeFirst();
		// list.removeLast();
		// list.removeLast();
		// System.out.println(list.getAt(5));
		// list.addAt(35, 1);
		// list.removeAt(2);
		// list.display();
		// list.displayReverse();
		// list.reversePointerIteratively();
		// list.reversePointerRecursively();
		// list.reverseDataRecursive();
		//System.out.println(list.isPalindrome());
		//list.fold();
		//list.display();
		//System.out.println(list.kthFromLast(4));
		//System.out.println(list.mid());
		
//		LinkedList one = new LinkedList();
//		one.addLast(10);
//		one.addLast(20);
//		one.addLast(30);
//		one.addLast(40);
//		
//		LinkedList two = new LinkedList();
//		two.addLast(5);
//		two.addLast(15);
//		two.addLast(25);
//		two.addLast(35);
//		
//		LinkedList merged = LinkedList.merge2SortedLL(one, two);
//		merged.display();
		
		//list = LinkedList.mergeSortLL(list);
		//list.oddEven();
		//list.removeDuplicates();
//		list.kthReverse(3);
//		list.display();
		
//		LinkedList one = new LinkedList();
//		one.addLast(5);
//		one.addLast(6);
//		one.addLast(7);
//		
//		LinkedList two = new LinkedList();
//		two.addLast(8);
//		two.addLast(6);
//		two.addLast(7);
//		
//		LinkedList.add2LL(one, two);
	}
}
