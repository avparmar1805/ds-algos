package jan21;

public class P157 {

	public static void main(String[] args) {
		int n = 6;
		int row = 0;
		
		while(row < n){
			int col = 0;
			int val = 1;
			
			while(col <= row){
				System.out.print(val + "\t");
				val = (val * (row - col)) / (col + 1);
				
				col++;
			}
			
			row++;
			System.out.println();
		}
		
		
	}

}
