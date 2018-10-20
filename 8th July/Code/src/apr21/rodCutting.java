package apr21;

public class rodCutting {

	public static void main(String[] args) {
		int[] costs = {0, 3, 5, 6, 15, 10, 25, 12, 24};
		rodCutting(costs);
	}
	
	public static void rodCutting(int[] costs){
		int[] msp = new int[costs.length];
		String[] mspcut = new String[costs.length];
		
		msp[0] = 0;
		msp[1] = costs[1];
		
		mspcut[0] = "";
		mspcut[1] = "1";
		
		for(int crl = 2; crl < costs.length; crl++){
			msp[crl] = costs[crl];
			mspcut[crl] = crl + "";
			
			int leftCut = 1;
			int rightCut = crl - 1;
			while(leftCut <= rightCut){
				if(msp[leftCut] + msp[rightCut] > msp[crl]){
					msp[crl] = msp[leftCut] + msp[rightCut];
					mspcut[crl] = mspcut[leftCut] + mspcut[rightCut];
				}
				
				leftCut++;
				rightCut--;
			}
		}

		System.out.println(mspcut[costs.length - 1] + "@" + msp[costs.length - 1]);
	}
	

}
