package june15;

public class Client {

	public static void main(String[] args) {
//		LinkedList list = new LinkedList();
//		list.addLast(10);
//		list.addLast(20);
//		list.addLast(30);
//		list.addLast(40);
//		list.addLast(50);
//		list.display();
//		
//		System.out.println(list.getAt(3));
//		System.out.println(list.getFirst());
//		list.addFirst(5);
//		list.display();
//		
//		list.addAt(100, 3);
//		list.display();
		
//		list.removeFirst();
//		list.display();
		
//		list.removeLast();
//		list.display();
		
//		list.removeAt(2);
//		
//		list.display();
//		list.reverseDataIterative();
//		list.display();
//		list.reversePointerRecursive();
//		list.reverseDataRecursive();
//		list.display();
//		list.fold();
//		list.display();
//		
//		System.out.println(list.mid());
//		System.out.println(list.kthFromLast(3));
//		
//		list.addLast(1000);
//		list.addLast(9);
//		
//		list.display();
//		list.kreverse(3);
//		list.display();
//		list.reversePointerIterative();
//		list.display();
		
//		LinkedList list2 = new LinkedList();
//		
//		list2.addLast(10);
//		list2.addLast(10);
//		list2.addLast(10);
//		list2.addLast(20);
//		list2.addLast(20);
//		list2.addLast(20);
//		list2.addLast(30);
//		list2.addLast(40);
//		list2.addLast(40);
//		list2.addLast(40);
//		list2.display();
//		list2.removeDuplicates();
//		System.out.println(list2.size());
//		list2.display();
//		
//		list2.addLast(1000);
//		list2.display();
//		
		
		LinkedList list1 = new LinkedList();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.addLast(50);
		list1.addLast(60);
		
		LinkedList list2 = new LinkedList();
		list2.addLast(5);
		list2.addLast(15);
		list2.addLast(18);
		list2.addLast(23);
		list2.addLast(31);
		list2.addLast(32);
		list2.addLast(45);
		list2.addLast(55);
		
		LinkedList list3 = LinkedList.merge(list1, list2);
		
		list1.display();
		list2.display();
		list3.display();
		
		list3.fold();
		list3.display();
		
		list3 = LinkedList.mergesort(list3);
		list3.display();
		
		list3.placeOddEven();
		list3.display();
		
	}

}
