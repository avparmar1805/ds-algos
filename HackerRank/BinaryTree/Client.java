package BinaryTree;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int[] arr = { 50, 25, 12, -1, 37, -1, -1, 75, 62, -1, 87, -1, -1, -1 };
		 BinaryTree bt = new BinaryTree(arr);
		 //bt.display(bt.root);
		 //bt.verticalOrderTraversal();
		 //bt.topView();
//		 int max = bt.max(bt.root);
//		 System.out.println("Max => " + max);
//		
//		 int size = bt.size(bt.root);
//		 System.out.println("size => " + size);
//		
//		 int height = bt.height(bt.root);
//		 System.out.println("height => " + height);
//		
//		 boolean find = bt.find(bt.root, 100);
//		 System.out.println("found => " + find);
//		
//		 ArrayList<Integer> al = bt.nodeToRootPath(bt.root, 37);
//		 for(int val: al) {
//		 System.out.print(val + " - ");
//		 }

//		int[] arr2 = { 10, 20, 40, -1, 50, 80, 140, -1, 150, -1, -1, 90, 120, -1, 130, -1, -1, -1, -1, 30, 160, -1, 170,
//				-1, -1 };
//
//		BinaryTree bt1 = new BinaryTree(arr2);
//		bt1.display(bt1.root);
//		bt1.printKDown(20, 3);
		
		int[] arr2 = { 'a','b', 'd', 'f', 'h', -1,-1,'g' , 'i', 'm', 'o', 'v', -1,-1, 'p', 't', -1,-1,-1, 'n', 'q','u',-1,'w'
			, -1,-1,-1,-1, 'j', 'k', 'r', 'x', -1 , -1, -1, 'l', 's', 'y', -1,-1,-1,-1,-1,-1,-1,'c','e', 'z', -1,-1,-1,-1};
		 //int[] arr2 = { 50, 25, 12, 10,3,1,-1,4,-1,-1,11,-1,-1,15,-1,-1,37,-1,-1 };
		 
		BinaryTree bt1 = new BinaryTree(arr2);
		bt1.display(bt1.root);
		bt1.printKFar('i', 3);

	}

}
