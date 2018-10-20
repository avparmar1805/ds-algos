package july8;

public class FenwickTree {
	
	int[] farr;
	public FenwickTree(int[] arr){
		farr = new int[arr.length + 1];
		
		for(int i = 0; i < arr.length; i++){
			update(i, arr[i]);
		}
	}
	
	public int query(int si, int ei){
		return prefixSum(ei) - prefixSum(si - 1);
	}
	
	public int prefixSum(int idx){
		idx++;
		int sum = 0;
		
		while(idx > 0){
			sum += farr[idx];
			idx -= (idx & -idx);
		}
		
		return sum;
	}
	
	public void update(int idx, int delta){
		idx++;
		
		while(idx < farr.length){
			farr[idx] += delta;
			idx += (idx & -idx);
		}
	}
	
}
