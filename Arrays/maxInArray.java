package Arrays;

public class maxInArray {
	public static void main (String[] args) {
		int[] arr = {10, 15, 60, 2, 18};
		
		int max = arr[0];
		
		for(int i= 1; i< arr.length;i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(max);
	}
}
