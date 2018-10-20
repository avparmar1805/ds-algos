package jan21;

public class P156 {

	public static void main(String[] args) {
		int n = 5;

		int n1 = 0;
		int n2 = 1;
		int n3 = 0;
		
		int row = 1;
		while (row <= n) {
			int col = 1;
			while (col <= row) {
				System.out.print(n1 + "\t");
				
				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;
				
				col++;
			}

			row++;
			System.out.println();
		}
	}

}
