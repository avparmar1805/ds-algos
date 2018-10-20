package feb4;

public class maxofarray {

	public static void main(String[] args) {
		int[] arr = {10, 45, 14, 97, 62, 33, -5};
		
		// max
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		
		System.out.println(max);
	}

}
