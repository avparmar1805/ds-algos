package mar17;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		ArrayList<Integer> alist;
		alist = new ArrayList<Integer>();
		
		System.out.println(alist);
		
		// add
		alist.add(10);
		alist.add(20);
		alist.add(30);
		System.out.println(alist);
		
		// length
		System.out.println(alist.size());
		
		// add as insert
		alist.add(1, 300);
		System.out.println(alist);
		
		// get
		System.out.println(alist.get(1));
		// set
		alist.set(1, 3000);
		System.out.println(alist);
		
		// remove
		alist.remove(5);
		System.out.println(alist);
		
		
		
		
	}

}
