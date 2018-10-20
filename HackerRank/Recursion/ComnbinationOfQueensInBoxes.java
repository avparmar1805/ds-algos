package Recursion;

public class ComnbinationOfQueensInBoxes {
	public static void main(String[] args) {
		combinations(new boolean[4], 2, 0, 0, "");
	}

	private static void combinations(boolean[] boxes, int tq, int qpsf, int siBox, String asf) {

		if (qpsf == tq) {
			System.out.println(asf);
			return;
		}

		for (int box = siBox; box < boxes.length; box++) {
			if (boxes[box] == false) {
				boxes[box] = true;
				combinations(boxes, tq, qpsf + 1, box + 1, asf + "q" + (qpsf + 1) + "b" + box + " ");
				boxes[box] = false;
			}
		}
	}
}
