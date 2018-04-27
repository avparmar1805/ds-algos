package Arrays;

public class linearSearch {
	public static void main (String[] args) {
		int[] arr = {10, 15, 60, 2, 18};
		
		int data = 44;
		int i= 0;
		for(i= 0; i< arr.length;i++) {
			if(data == arr[i]) {
				System.out.println(i);
				return;
			}
		}
		if(i == arr.length) {
			System.out.println(-1);
		}
	}
}
