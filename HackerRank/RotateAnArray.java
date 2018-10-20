
public class RotateAnArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int d = 3;
		
		Reverse(arr, 0, arr.length -1 - d);
		Reverse(arr, arr.length - d, arr.length - 1);
		Reverse(arr, 0, arr.length - 1);
		
		for(int val: arr) {
			System.out.print(val + " ");
		}
	}
	
	private static void Reverse(int[] arr, int left, int right) {
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			
			left++;
			right--;
		}
	}

}
