package mar10;

public class Client {

	public static void main(String[] args) {
//		int[] arr = {5, 18, 2, 17, 6};
//		display(arr, 0);
//		System.out.println(max(arr, 0));
//		int[] arr = {8, 2, 7, 8, 9, 3, 8, 5};
//		int[] rarr = allIndices(arr, 8, 0, 0);
//		for(int val: rarr){
//			System.out.print(val + " ");
//		}
		
	}
	
	public static void display(int[] arr, int vidx){
		if(vidx == arr.length){
			return;
		}
		
		System.out.println(arr[vidx]);
		display(arr, vidx + 1);
	}

	public static void displayR(int[] arr, int vidx){
		
	}
	
	public static int max(int[] arr, int vidx){
		if(vidx == arr.length - 1){
			return arr[vidx];
		}
		
		int misa = max(arr, vidx + 1);
		if(misa > arr[vidx]){
			return misa;
		} else {
			return arr[vidx];
		}
	}

	public static boolean findStupid(int[] arr, int data, int vidx){
		if(vidx == arr.length){
			return false;
		}
		
		boolean fisa = findStupid(arr, data, vidx + 1);
		if(fisa == true){
			return true;
		} else if(arr[vidx] == data){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean findSmart(int[] arr, int data, int vidx){
		if(vidx == arr.length){
			return false;
		}

		if(arr[vidx] == data){
			return true;
		} else {
			boolean fisa = findSmart(arr, data, vidx + 1);
			return fisa;
		}
	}

	public static int firstIndex(int[] arr, int data, int vidx){
		if(vidx == arr.length){
			return -1;
		}

		if(arr[vidx] == data){
			return vidx;
		} else {
			int fiisa = firstIndex(arr, data, vidx + 1);
			return fiisa;
		}
	}
	
	public static int lastIndex(int[] arr, int data, int vidx){
		if(vidx == arr.length){
			return -1;
		}
		
		int liisa = lastIndex(arr, data, vidx + 1);
		if(liisa != -1){
			return liisa;
		} else if(arr[vidx] == data){
			return vidx;
		} else {
			return -1;
		}
	}
	
	public static int[] allIndices(int[] arr, int data, 
								   int vidx, int fsf){
		if(vidx == arr.length){
			return new int[fsf];
		}
		
		
		if(arr[vidx] == data){
			fsf++;
		}
		
		int[] rarr = allIndices(arr, data, vidx + 1, fsf);
		
		if(arr[vidx] == data){
			fsf--;
			rarr[fsf] = vidx;
		}
		
		return rarr;
	}
	
	
	
	
	
	
	
	
	
}
