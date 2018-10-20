import java.util.Scanner;

public class Sort012 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in;
		in = new Scanner(System.in);
		int arrLength = in.nextInt();
		int[] arr = new int[arrLength];
		
		for (int i = 0; i < arrLength; i++) {
			arr[i] = in.nextInt();
		}
		
		int[] sortedArray = Sort012s(arr);
		Display(sortedArray);
	}
	
	public static void Display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
	
	public static int[] Sort012s(int[] arr) {
		
		int si = 0;
		int mid = 0;
		int li = arr.length - 1;
		
		while(mid <= li) {
			if(arr[mid] == 0) {
				int temp = arr[si];
				arr[si] = arr[mid];
				arr[mid] = temp;
				si++;
				mid++;
			} else if(arr[mid] == 1) {
				mid++;
			} else if(arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[li];
				arr[li] = temp;
				li--;
			}			
		}
		
		return arr;
	}
	
}
