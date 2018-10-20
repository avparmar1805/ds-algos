package jan21;

public class P151 {

	public static void main(String[] args) {
		int n = 5;
		
		int row = 1;
		while(row <= n){
			int col = 1;
			while(col <= row){
				System.out.print("*");
				col++;
			}
			
			row++;
			System.out.println();
		}
	}

}
