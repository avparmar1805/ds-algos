package feb4;

public class inverse {

	public static void main(String[] args) {
		int[] arr = {4, 1, 0, 3, 2};
		int[] inv = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			inv[arr[i]] = i;
		}
		
		for(int i = 0; i < inv.length; i++){
			System.out.print(inv[i] + " ");
		}
		System.out.println(".");
	}

}
