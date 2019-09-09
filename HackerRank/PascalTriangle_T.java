
public class PascalTriangle_T {

	public static void main(String[] args) {
		int n = 5;
		
		for(int i=0;i<=n;i++) {
			
			int val = 1; //nC0
			for(int j =0; j<=i;j++) {
				
				System.out.print(val + " ");
				int nckp1 = val*(i-j)/(j+1) ; //nCk+1 = nCk(n-k)/k+1;
//				System.out.print(nckp1+" ");
				val = nckp1;
			}
				System.out.println();	
		}
		

	}

}
