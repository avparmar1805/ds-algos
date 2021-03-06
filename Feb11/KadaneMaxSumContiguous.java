package Feb11;

public class KadaneMaxSumContiguous {
	public static void main(String[] args) {
		int[] arr = { 5,-8,2,7,12,3,-25,15,7,3 };
		
		int omax = arr[0];
		int osp = 0;
		int oep = 0;
		int cmax = omax;
		int csp = 0;
		int cep = 0;
		
		for(int i = 1; i<arr.length; i++) {
			if(cmax > 0) {
				cmax = cmax + arr[i];
				cep = i;
			} else {
				cmax = arr[i];
				csp = i;
				cep = i;
			}
			
			if(cmax > omax) {
				omax = cmax;
				osp = csp;
				oep = cep;
			}
		}
		System.out.println(omax);
		for(int i = osp; i<= oep; i++) {
			System.out.print(arr[i] + " " );
		}
	}
}
