package jan21;

public class P155 {

	public static void main(String[] args) {
		int n = 5;
		
		int row = 1;
		int val = 1;
		while(row <= n){
			int col = 1;
			while(col <= row){
				System.out.print(val + "\t");
				val++;
				col++;
			}
			
			row++;
			System.out.println();
		}
	}

}
