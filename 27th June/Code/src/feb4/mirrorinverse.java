package feb4;

public class mirrorinverse {

	public static void main(String[] args) {
		int[] arr = {3, 4, 2, 0, 1};
		
		for(int i = 0; i < arr.length; i++){
			if(arr[arr[i]] != i){
				System.out.println("no");
				return;
			}
		}
		
		System.out.println("yes");
	}

}
