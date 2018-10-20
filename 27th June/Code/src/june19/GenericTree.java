package june19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		root = takeInput(null, 0, new Scanner(System.in));
	}

	// expectation -> creates returns ith child of parent
	private Node takeInput(Node parent, int i, Scanner scn) {
		if (parent == null) {
			System.out.println("Enter the data of root");
		} else {
			System.out.println("Enter the data for " + i + "th child of " + parent.data);
		}

		int cdata = scn.nextInt();

		Node child = new Node();
		size++;
		child.data = cdata;

		System.out.println("Enter the number of children for " + child.data);

		int numChildrenOfChild = scn.nextInt();
		for (int j = 0; j < numChildrenOfChild; j++) {
			Node childsJthChild = takeInput(child, j, scn);
			child.children.add(childsJthChild);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(root);
	}

	// Expectation -> that it display the node and all of its family
	private void display(Node node) {
		String s = node.data + " -> ";
		for (Node child : node.children) {
			s += child.data + ", ";
		}

		System.out.println(s + ".");

		for (Node child : node.children) {
			display(child);
		}
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int nsize = 0;

		for (Node child : node.children) {
			int csize = size2(child);
			nsize += csize;
		}

		nsize += 1; // for the node itself

		return nsize;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		int max = node.data;

		for (Node child : node.children) {
			int cmax = max(child);
			if (cmax > max) {
				max = cmax;
			}
		}

		return max;
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		int ht = -1;

		for (Node child : node.children) {
			int cht = height(child);
			if (cht > ht) {
				ht = cht;
			}
		}

		return ht + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}

		for (Node child : node.children) {
			boolean fictree = find(child, data);
			if (fictree == true) {
				return true;
			}
		}

		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}

		Collections.reverse(node.children);
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) { // leaf
				node.children.remove(child);
				i--;
			} else {
				removeLeaves(child);
			}
		}
	}

	public void preo() {
		preo(root);
		System.out.println(".");
	}

	private void preo(Node node) {
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preo(child);
		}
	}

	public void posto() {
		posto(root);
		System.out.println(".");
	}

	private void posto(Node node) {
		for (Node child : node.children) {
			posto(child);
		}
		System.out.print(node.data + " ");
	}

	public void areas() {
		areas(root);
	}

	private void areas(Node node) {
		System.out.println("Hi " + node.data);
		for (Node child : node.children) {
			System.out.println("From " + node.data + " to " + child.data);
			areas(child);
			System.out.println("Back to " + node.data + " from " + child.data);
		}
		System.out.println("Bye " + node.data);
	}

	// private void removeLeaves2(Node node){
	// for(int i = 0; i < node.children.size(); i++){
	// Node child = node.children.get(i);
	//
	// if(child.children.size() == 0){
	// node.children.remove(i);
	// i--;
	// }
	// }
	//
	// for(Node child: node.children){
	// if(child.children.size() > 0){
	// removeLeaves2(child);
	// }
	// }
	//
	//
	// }

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		while (queue.size() > 0) {
			// 1. de
			Node rn = queue.removeFirst();

			// 2. print
			System.out.print(rn.data + " ");

			// 3. enq child
			for (Node child : rn.children) {
				queue.addLast(child);
			}
		}
		System.out.println(".");
	}

	public void leverOrderLW() {
		LinkedList<Node> cl = new LinkedList<>();
		LinkedList<Node> nl = new LinkedList<>();

		cl.add(root);

		while (cl.size() > 0 || nl.size() > 0) {
			Node rn = cl.removeFirst();
			System.out.print(rn.data + " ");

			for (Node child : rn.children) {
				nl.addLast(child);
			}

			if (cl.size() == 0) {
				System.out.println();
				cl = nl;
				nl = new LinkedList<>();
			}
		}
	}

	public void levelOrderLWZZ() {
		LinkedList<Node> clqueue = new LinkedList<>();
		LinkedList<Node> nlstack = new LinkedList<>();

		clqueue.add(root);
		boolean l2r = true;

		while (clqueue.size() > 0 || nlstack.size() > 0) {
			Node rem = clqueue.removeFirst();

			System.out.print(rem.data + " ");

			if (l2r == true) {
				for (int i = 0; i < rem.children.size(); i++) {
					Node child = rem.children.get(i);
					nlstack.addFirst(child);
				}
			} else {
				for (int i = rem.children.size() - 1; i >= 0; i--) {
					Node child = rem.children.get(i);
					nlstack.addFirst(child);
				}
			}

			if (clqueue.size() == 0) {
				System.out.println();
				clqueue = nlstack;
				nlstack = new LinkedList<>();
				l2r = !l2r;
			}
		}
	}

	public void linerarize() {
		// linearize(root);
		linearizeEff(root);
	}

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		for (int i = node.children.size() - 1; i >= 1; i--) {
			Node im1node = node.children.get(i - 1);
			Node inode = node.children.get(i);

			Node im1tail = getTail(im1node);
			node.children.remove(i);
			im1tail.children.add(inode);
		}
	}

	private Node getTail(Node node) {
		Node temp = node;

		while (temp.children.size() != 0) {
			temp = temp.children.get(0);
		}

		return temp;
	}

	private Node linearizeEff(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node lastchild = node.children.get(node.children.size() - 1);
		Node overalltail = linearizeEff(lastchild);

		for (int i = node.children.size() - 1; i >= 1; i--) {
			Node inode = node.children.get(i);
			Node im1node = node.children.get(i - 1);

			Node im1tail = linearizeEff(im1node);
			node.children.remove(i);
			im1tail.children.add(inode);
		}

		return overalltail;
	}

	private class HeaMover {
		int size = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int height = 0;
		boolean found = false;

		Node pred = null;
		Node succ = null;
		Node prev = null;
		Node jl = null;
	}

	public void mutlisolver(int data) {
		HeaMover mover = new HeaMover();
		multisolver(root, mover, data, 0);

		System.out.println("Size = " + mover.size);
		System.out.println("Min = " + mover.min);
		System.out.println("Max = " + mover.max);
		System.out.println("Found = " + mover.found);
		System.out.println("Height = " + mover.height);
		System.out.println("Pred = " + (mover.pred == null ? "Not found" : mover.pred.data));
		System.out.println("Succ = " + (mover.succ == null ? "Not found" : mover.succ.data));
		System.out.println("Just Larger = " + (mover.jl == null ? "Not found" : mover.jl.data));
	}

	private void multisolver(Node node, HeaMover mover, int data, int depth) {
		if (node.data == data) {
			mover.pred = mover.prev;
		} else if (mover.prev != null && mover.prev.data == data) {
			mover.succ = node;
		}

		if (node.data > data) {
			if (mover.jl == null) {
				mover.jl = node;
			} else if (node.data < mover.jl.data) {
				mover.jl = node;
			}
		}

		mover.size++;

		if (node.data < mover.min) {
			mover.min = node.data;
		}
		if (node.data > mover.max) {
			mover.max = node.data;
		}
		if (node.data == data) {
			mover.found = true;
		}
		if (depth > mover.height) {
			mover.height = depth;
		}

		mover.prev = node;
		for (Node child : node.children) {
			multisolver(child, mover, data, depth + 1);
		}
	}

	public int kthSmallest(int k) {
		int kthSmallest = Integer.MIN_VALUE;

		HeaMover mover = new HeaMover();
		for (int i = 0; i < k; i++) {
			multisolver(root, mover, kthSmallest, 0);
			kthSmallest = mover.jl.data;
			mover.jl = null;
		}

		return kthSmallest;
	}

	public boolean isIsomorphic(GenericTree other) {
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(i);

			if (isIsomorphic(tchild, ochild) == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isMirrorImage(GenericTree other) {
		return isMirrorImage(this.root, other.root);
	}

	private boolean isMirrorImage(Node tnode, Node onode) {
		if (tnode.children.size() != onode.children.size()) {
			return false;
		}

		for (int i = 0; i < tnode.children.size(); i++) {
			Node tchild = tnode.children.get(i);
			Node ochild = onode.children.get(onode.children.size() - 1 - i);

			if (isMirrorImage(tchild, ochild) == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isSymmetric() {
		return isMirrorImage(this.root, this.root);
	}

	private static class Pair {
		Node node;
		int nocPushed = 0;
		boolean printed = false;
	}

	public void preoiterative() {
		LinkedList<Pair> stack = new LinkedList<>();

		Pair rootpair = new Pair();
		rootpair.node = root;
		stack.addFirst(rootpair);

		while (stack.size() > 0) {
			Pair tp = stack.getFirst();

			if (tp.printed == false) {
				System.out.print(tp.node.data + " ");
				tp.printed = true;
			} else if (tp.nocPushed < tp.node.children.size()) {
				Pair p2bpushed = new Pair();
				p2bpushed.node = tp.node.children.get(tp.nocPushed);
				stack.addFirst(p2bpushed);
				tp.nocPushed++;
			} else {
				stack.removeFirst();
			}
		}
		
		System.out.println(".");
	}
}
