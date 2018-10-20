package jan27;

public class P152 {

	public static void main(String[] args) {
		int n = 7;

		int nst = 1;
		int nsp = n / 2;

		int row = 1;
		while (row <= n) {
//			System.out.print(nsp + " spaces " + nst + " stars");
			for(int i = 0; i < nsp; i++){
				System.out.print(" ");
			}
			
			for(int i = 0; i < nst; i++){
				System.out.print("*");
			}
			
			if (row <= n / 2) {
				nsp--;
				nst = nst + 2;
			} else {
				nsp++;
				nst = nst - 2;
			}
			
			row++;
			System.out.println();
		}
	}

}
