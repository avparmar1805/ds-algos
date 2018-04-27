package Arrays;

public class InverseArray {
	public static void main (String[] args) {
		int[] arr = {2,1,4,0,3};
		int[] inv = new int[arr.length];
		
		for(int i=0; i<arr.length;i++) {
			inv[arr[i]] = i;
		}

		for(int j = 0; j< inv.length; j++) {
			System.out.println(inv[j]);
		}
	}
}
