package Recursion;

public class PermutationOfQueensInBoxes {
	public static void main(String[] args) {
		permutations(new boolean[4], 2, 0, "");
	}

	private static void permutations(boolean[] boxes, int tq, int qpsf, String asf) {

		if (qpsf == tq) {
			System.out.println(asf);
			return;
		}

		for (int box = 0; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				permutations(boxes, tq, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + box+" ");
				boxes[box] = false;
			}
		}
	}
}
