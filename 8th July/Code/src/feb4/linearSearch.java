package feb4;

public class linearSearch {

	public static void main(String[] args) {
		int[] arr = {10, 45, 14, 97, 62, 14, -5};
		int data = 14;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == data){
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
	}

}
