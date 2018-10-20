package june23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public BinaryTree() {
		this.root = takeInput(new Scanner(System.in), null, false);
	}

	private Node takeInput(Scanner scn, Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			if (ilc == true) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int cdata = scn.nextInt();

		Node child = new Node();
		this.size++;
		child.data = cdata;

		System.out.println("Do you have a left child for " + child.data);
		boolean hlc = scn.nextBoolean();

		if (hlc == true) {
			child.left = takeInput(scn, child, true);
		}

		System.out.println("Do you have a right child for " + child.data);
		boolean hrc = scn.nextBoolean();

		if (hrc == true) {
			child.right = takeInput(scn, child, false);
		}

		return child;
	}

//	public BinaryTree(int[] preo, int[] ino){
//		root = construct(preo, ino, 0, preo.length - 1, 0, ino.length - 1);
//	}
//	
//	private Node construct(int[] preo, int[] ino, int psi, int pei, int isi, int iei){
//		if(psi > pei || isi > iei){
//			return null;
//		}
//		
//		Node child = new Node();
//		child.data = preo[psi];
//		this.size++;
//		
//		int sidx = -1;
//		for(int i = isi; i <= iei; i++){
//			if(child.data == ino[i]){
//				sidx = i;
//				break;
//			}
//		}
//		
//		int cle = sidx - isi;
//		
//		child.left = construct(preo, ino, psi + 1, psi + cle, isi, sidx - 1);
//		child.right = construct(preo, ino, psi + cle + 1, pei, sidx + 1, iei);
//		
//		return child;
//	}
	
	public BinaryTree(int[] posto, int[] ino){
		root = construct(posto, ino, 0, posto.length - 1, 0, ino.length - 1);
	}
	
	private Node construct(int[] posto, int[] ino, int psi, int pei, int isi, int iei){
		if(psi > pei || isi > iei){
			return null;
		}
		
		Node node = new Node();
		node.data = posto[pei];
		this.size++;
		
		int sidx = -1;
		for(int i = isi; i <= iei; i++){
			if(ino[i] == node.data){
				sidx = i;
				break;
			}
		}
		
		int rhs = iei - sidx;
		node.right = construct(posto, ino, pei - rhs, pei - 1, sidx + 1, iei);
		node.left = construct(posto, ino, psi, pei - rhs - 1, isi, sidx - 1);
		
		return node;
	}
	
	public void display() {
		display(root);
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}

		String str = node.left != null ? node.left.data + " " : ". ";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data + " " : " .";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;

		}

		int ls = size2(node.left);
		int rs = size2(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmax = max(node.left);
		int rmax = max(node.right);

		int max = Math.max(node.data, Math.max(lmax, rmax));
		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1; // 0 for nodes, -1 for edges
		}

		int lh = height(node.left);
		int rh = height(node.right);

		return Math.max(lh, rh) + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		}

		boolean filc = find(node.left, data);
		if (filc == true) {
			return true;
		}

		boolean firc = find(node.right, data);
		if (firc == true) {
			return true;
		}

		return false;
	}

	public ArrayList<Integer> nodeToRootPath(int data) {
		return nodeToRootPath(root, data);
	}

	// expectation -> to return data se node tak ka path
	// faith -> data se node ke child tak ka path to mil jaega
	private ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(node.data);
			return path;
		}

		ArrayList<Integer> lcpath = nodeToRootPath(node.left, data);
		if (lcpath.size() > 0) { // mil gya left side pe
			lcpath.add(node.data);
			return lcpath;
		}

		ArrayList<Integer> rcpath = nodeToRootPath(node.right, data);
		if (rcpath.size() > 0) {
			rcpath.add(node.data);
			return rcpath;
		}

		return new ArrayList<>();
	}

	public void rootToLeafPathWithTargetSum(int lo, int hi) {
		rootToLeafPathWithTargetSum(root, 0, "$", lo, hi);
	}

	public void rootToLeafPathWithTargetSum(Node node, int ssf, String psf, int lo, int hi) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			ssf += node.data;
			psf += " -> " + node.data;

			if (ssf >= lo && ssf <= hi) {
				System.out.println(psf);
			}
			return;
		}

		rootToLeafPathWithTargetSum(node.left, ssf + node.data, psf + " -> " + node.data, lo, hi);
		rootToLeafPathWithTargetSum(node.right, ssf + node.data, psf + " -> " + node.data, lo, hi);
	}

	public void removeLeaves() {

		removeLeaves(null, root);
	}

	private void removeLeaves(Node parent, Node node) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) { // leaf
			if (node == parent.left) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}

		removeLeaves(node, node.left);
		removeLeaves(node, node.right);
	}

	public void printSingleChild() {
		printSingleChild(null, root);
	}

	private void printSingleChild(Node parent, Node node) {
		if (node == null) {
			return;
		}

		if (parent != null) {
			if (parent.left == null && parent.right != null) {
				System.out.println(node.data);
			} else if (parent.right == null && parent.left != null) {
				System.out.println(node.data);
			}
		}

		printSingleChild(node, node.left);
		printSingleChild(node, node.right);
	}

	public void printkfar(int data, int k) {
		ArrayList<Node> path = nodeToRootPath2(root, data);

		for (int i = 0; i <= k && i < path.size(); i++) {
			if (i == 0) {
				printkdown(path.get(i), k);
			} else if (i < k) {
				Node prev = path.get(i - 1);
				Node curr = path.get(i);

				if (prev == curr.left) {
					printkdown(curr.right, k - i - 1);
				} else {
					printkdown(curr.left, k - i - 1);
				}
			} else {
				Node curr = path.get(i);
				System.out.println(curr.data);
			}
		}
	}

	private void printkdown(Node node, int k) {
		if (node == null) {
			return;
		}

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printkdown(node.left, k - 1);
		printkdown(node.right, k - 1);
	}

	private ArrayList<Node> nodeToRootPath2(Node node, int data) {
		if (node == null) {
			return new ArrayList<>();
		}

		if (node.data == data) {
			ArrayList<Node> path = new ArrayList<>();
			path.add(node);
			return path;
		}

		ArrayList<Node> lcpath = nodeToRootPath2(node.left, data);
		if (lcpath.size() > 0) { // mil gya left side pe
			lcpath.add(node);
			return lcpath;
		}

		ArrayList<Node> rcpath = nodeToRootPath2(node.right, data);
		if (rcpath.size() > 0) {
			rcpath.add(node);
			return rcpath;
		}

		return new ArrayList<>();
	}

	public void preo(){
		preo(root);
		System.out.println(".");
	}
	
	private void preo(Node node){
		if(node == null){
			return;
		}
		
		System.out.print(node.data + " ");
		preo(node.left);
		preo(node.right);
	}
	
	public void posto(){
		posto(root);
		System.out.println(".");
	}
	
	private void posto(Node node){
		if(node == null){
			return;
		}
		
		posto(node.left);
		posto(node.right);
		System.out.print(node.data + " ");
	}
	
	public void ino(){
		ino(root);
		System.out.println(".");
	}
	
	private void ino(Node node){
		if(node == null){
			return;
		}
		
		ino(node.left);
		System.out.print(node.data + " ");
		ino(node.right);
	}

	public void levelo(){
		LinkedList<Node> queue = new LinkedList<>();
		
		queue.addLast(root);
		while(queue.size() > 0){
			Node rem = queue.removeFirst();
			System.out.print(rem.data + " ");
			
			if(rem.left != null){
				queue.addLast(rem.left);
			}
			
			if(rem.right != null){
				queue.addLast(rem.right);
			}
		}
		System.out.println(".");
	}

	public int diameter(){
		return diameter(root);
	}
	
	// maximum distance between any two nodes under the node
	private int diameter(Node node){
		if(node == null){
			return 0;
		}
		
		int lh = height(node.left); // distance of deepest node from left node
		int rh = height(node.right); // distance of deepest node from right node
		int f1 = lh + rh + 2; // 2 for the distance between left node and right node

		int ld = diameter(node.left); // maximum distance beteen nodes in left subtree
		int rd = diameter(node.right); // maximum distance beteen nodes in right subtree
		
		return Math.max(f1, Math.max(ld, rd));
	}
	
	private class DiaPair{
		int ht;
		int dia;
	}
	
	public int diameter2(){
		DiaPair pp = diameter2(root);
		return pp.dia;
	}
	
	private DiaPair diameter2(Node node){
		if(node == null){
			DiaPair bp = new DiaPair();
			
			bp.dia = 0;
			bp.ht = -1;
			
			return bp;
		}
		
		DiaPair lp = diameter2(node.left);
		DiaPair rp = diameter2(node.right);
		
		DiaPair mp = new DiaPair();
		mp.ht = Math.max(lp.ht, rp.ht) + 1;
		mp.dia = Math.max(lp.ht + rp.ht + 2, Math.max(lp.dia, rp.dia));
		
		return mp;
	}
	
	private class BalPair {
		int height;
		boolean isBal;
	}
	
	public boolean IsBalanced(){
		BalPair bp = IsBalanced(root);
		return bp.isBal;
	}
	
	private BalPair IsBalanced(Node node){
		if(node == null){
			BalPair mp = new BalPair();
			
			mp.height = -1;
			mp.isBal = true;
			
			return mp;
		}
		
		BalPair lp = IsBalanced(node.left); 
		BalPair rp = IsBalanced(node.right);
		
		BalPair mp = new BalPair();
		
		mp.height = Math.max(lp.height, rp.height) + 1;
		if(lp.isBal && rp.isBal && Math.abs(lp.height - rp.height) <= 1){
			mp.isBal = true;
		}
		
		return mp;
	}
	
	private class BSTPair {
		boolean isBST;
		int min;
		int max;
		Node lbstroot;
		int lbstsize;
	}
	
	public boolean isBST(){
		BSTPair pp = isBST(root);

		System.out.println(pp.lbstroot.data + "@" + pp.lbstsize);
		
		return pp.isBST;
	}
	
	private BSTPair isBST(Node node){
		if(node == null){
			BSTPair bp = new BSTPair();
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.isBST = true;
			return bp;
		}
		
		BSTPair lp = isBST(node.left);
		BSTPair rp = isBST(node.right);
		
		BSTPair mp = new BSTPair();
		mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		
		if(lp.isBST == true && rp.isBST == true && node.data >= lp.max && node.data < rp.min){
			mp.isBST = true;
			mp.lbstroot = node;
			mp.lbstsize = lp.lbstsize + rp.lbstsize + 1;
		} else {
			mp.isBST = false;
			if(lp.lbstsize > rp.lbstsize){
				mp.lbstroot = lp.lbstroot;
				mp.lbstsize = lp.lbstsize;
			} else {
				mp.lbstroot = rp.lbstroot;
				mp.lbstsize = rp.lbstsize;
			}
		}
		
		return mp;
	}
	
	private class Pair {
		Node node;
		boolean isPrinted;
		boolean isLeftPushed;
		boolean isRightPushed;
		
		Pair(Node node, boolean isPrinted, boolean isLeftPushed, boolean isRightPushed){
			this.node = node;
			this.isPrinted = isPrinted;
			this.isLeftPushed = isLeftPushed;
			this.isRightPushed = isRightPushed;
		}
	}
	
	public void preoI(){
		Pair rootpair = new Pair(root, false, false, false);
		
		LinkedList<Pair> stack = new LinkedList<>();
		stack.addFirst(rootpair);
		
		while(stack.size() > 0){
			Pair top = stack.getFirst();
			
			if(top.isPrinted == false){
				top.isPrinted = true;
				System.out.print(top.node.data + " ");
			} else if(top.isLeftPushed == false){
				top.isLeftPushed = true;
				
				if(top.node.left != null){
					Pair lp = new Pair(top.node.left, false, false, false);
					stack.addFirst(lp);
				}
			} else if(top.isRightPushed == false){
				top.isRightPushed = true;
				
				if(top.node.right != null){
					Pair rp = new Pair(top.node.right, false, false, false);
					stack.addFirst(rp);
				}
			} else {
				stack.removeFirst();
			}
		}
		
		System.out.println(".");
	}
}
