package june23;

import java.util.LinkedList;

public class Client {

	// 50 true 25 true 12 false false true 37 true 30 false false true 40 false
	// false true 75 true 60 true 55 false false true 65 false false true 87
	// false false

	// 50 true 25 true 12 false false true 37 true 30 false false
	// true 40 false false true 75 true 60 true 55 false false true
	// 65 false false true 87 false false
	public static void main(String[] args) {
		// int[] preo = {50, 25, 12, 37, 30, 40, 75, 62, 87};
		int[] posto = { 12, 30, 40, 37, 25, 62, 87, 75, 50 };
		// System.out.println(posto);
		int[] ino = { 12, 25, 30, 37, 40, 50, 62, 75, 87 };
		BinaryTree bt = new BinaryTree(posto, ino);
		bt.display();
		bt.preo();
		bt.preoI();
		// bt.display();
		// System.out.println(bt.diameter());
		// System.out.println(bt.diameter2());
		// System.out.println(bt.isBST());
		// bt.display();
		// bt.levelo();

		// System.out.println(bt.nodeToRootPath(65));
		// bt.rootToLeafPathWithTargetSum(150, 250);
		// bt.removeLeaves();
		// System.out.println("--------------------");
		// bt.display();
		// bt.printSingleChild();

		// bt.printkfar(14, 3);
		// bt.preo();
		// bt.posto();
		// bt.ino();

		// printBinaries(15);

	}

	private static class Pair {
		int num;
		String bin = "";

		Pair(int num, String bin) {
			this.num = num;
			this.bin = bin;
		}
	}

	private static void printBinaries(int max) {
		Pair rootp = new Pair(1, "1");

		LinkedList<Pair> queue = new LinkedList<>();
		queue.addLast(rootp);

		while (queue.size() > 0) {
			// deq, print, enq
			Pair rem = queue.removeFirst();

			System.out.println(rem.num + " -> " + rem.bin);

			Pair lp = new Pair(2 * rem.num, rem.bin + "0");
			if (lp.num <= max) {
				queue.addLast(lp);
			}

			Pair rp = new Pair(2 * rem.num + 1, rem.bin + "1");
			if (rp.num <= max) {
				queue.addLast(rp);
			}
		}
	}

}
