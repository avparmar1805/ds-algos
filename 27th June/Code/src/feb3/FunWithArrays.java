package feb3;

public class FunWithArrays {

	public static void main(String[] args) {
		int[] arr; // only on stack
		
		arr = new int[5]; // on heap, address on stack
		
		arr[0] = 0;
		arr[1] = 10;
		arr[2] = 20;
		arr[3] = 30;
		arr[4] = 40;
		
		// print
		System.out.println(arr);
		
		// print again
		System.out.println(arr.length);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println(".");
		
		// enhanced for loop
		for(int val: arr){
			val = val + 10;
		}
	}

}
