
public class PatterFib_T {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 1;
		int n =4;
		
		for(int i=0; i<n; i++) {
			
			for(int j= 0 ;j<=i;j++) {
				
				System.out.print(a +" ");
				int c = a+b;
				a=b;
				b=c;
				
			}
			System.out.println();
		}

	}
}

