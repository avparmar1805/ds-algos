package Recursion;

public class RecursionQns {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		boolean isFound = find(arr, 0, 20);
		System.out.println("IsFound => " + isFound);
		int[] firstIndexArr = { 10, 20, 20, 40, 50 };
		int firstIndex = firstIndex(firstIndexArr, 0, 41);
		System.out.println("First Index => " + firstIndex);
		int[] lastIndexArr = { 10, 20, 20, 40, 20 };
		int lastIndex = lastIndex(lastIndexArr, 0, 20);
		System.out.println("last Index => " + lastIndex);
		int[] allIndexArr = { 10, 10, 10, 0, 10 };
		System.out.println("All Index => ");
		int[] allIndex = allIndex(allIndexArr, 0, 10, 0);
		//Display(allIndex);
		int[] arrToInverse = {1,2,3,4,5,6,7,8};
		int[] inversedArr = inverse(arrToInverse, 0);
		Display(inversedArr);
	}

	public static int[] inverse(int[] arr, int vidx) {
		if(vidx == arr.length/2) {
			return arr;
		}
		
		int temp = arr[vidx];
		int backVidx = arr.length-1-vidx;
		arr[vidx] = arr[backVidx];
		arr[backVidx] = temp;
		inverse(arr, vidx+1);
		
		return arr;
	}
	
	public static void Display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] allIndex(int[] arr, int vidx, int data, int countSoFar) {
		int[] allIndexSmallArr = null;

		if (vidx == arr.length) {
			return new int[countSoFar];
		}

		if (arr[vidx] == data) {
			countSoFar++;	
		}
		allIndexSmallArr = allIndex(arr, vidx + 1, data, countSoFar);
		
		if (arr[vidx] == data) {
			countSoFar--;
			allIndexSmallArr[countSoFar] = vidx;
		}
		return allIndexSmallArr;
	}

	public static boolean find(int[] arr, int vidx, int data) {
		boolean isFound = false;
		if (vidx == arr.length - 1) {
			if (arr[vidx] == data) {
				return true;
			} else {
				return false;
			}
		}

		if (arr[vidx] == data) {
			isFound = true;
		} else {
			isFound = find(arr, vidx + 1, data);
		}

		return isFound;
	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		int lastIndex = -1;

		if (vidx == arr.length) {
			return -1;
		}

		lastIndex = lastIndex(arr, vidx + 1, data);
		if (lastIndex != -1) {
			return lastIndex;
		} else if (arr[vidx] == data) {
			return vidx;
		} else {
			return lastIndex;
		}

	}

	public static int firstIndex(int[] arr, int vidx, int data) {
		int foundIndex = -1;
		if ((vidx == arr.length - 1)) {
			if ((arr[vidx] == data)) {
				return vidx;
			} else {
				return foundIndex;
			}
		}
		if (arr[vidx] == data) {
			foundIndex = vidx;
		} else {
			foundIndex = firstIndex(arr, vidx + 1, data);
		}

		return foundIndex;
	}
}
