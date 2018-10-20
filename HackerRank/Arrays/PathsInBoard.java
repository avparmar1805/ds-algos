package Arrays;

public class PathsInBoard {
	public static void main(String[] args) {
		pathsInBoard(0, 10, "");
	}
	private static int counter = 0;
	private static void pathsInBoard(int source, int dest, String psf) {

		if (source == dest) {
			counter++;
			System.out.println("Path => " + psf + " Counter =>" + counter);
			return;
		}
		
		if (source > dest) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			int intermediate = source + dice;
			pathsInBoard(intermediate, dest, psf + "" + dice);
		}
	}
}
