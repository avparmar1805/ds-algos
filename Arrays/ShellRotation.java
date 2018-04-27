package Arrays;

import Feb11.Sortings;

public class ShellRotation {
	public static void main(String[] args) {
		// Find boundaries
		// Fill Linear array from boundaries
		// Rotate linear array
		// Fill back main array from linear array
		int[][] arr = { { 11, 12, 13, 14, 15, 16 }, { 21, 22, 23, 24, 25, 26 }, { 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, { 51, 52, 53, 54, 55, 56 }, { 61, 62, 63, 64, 65, 66 } };
		int sno = 2;
		int d = 3;
		rotateShell(arr, sno, d);
	}

	public static void rotateShell(int[][] arr, int sno, int d) {
		int rmin = 0;
		int rmax = arr.length;
		int cmin = 0;
		int cmax = arr[0].length;

		rmin = rmin + (sno - 1);
		rmax = arr.length - (sno);

		cmin = cmin + (sno - 1);
		cmax = arr[0].length - (sno);
		int noOfItems = 2 * (rmax - rmin + cmax - cmin);
		int[] shellArray = new int[noOfItems];
		int counter = 0;

		while (counter < noOfItems) {
			// Left Wall
			for (int i = rmin; i <= rmax; i++) {
				shellArray[counter] = arr[i][cmin];
				counter++;
			}
			cmin++;
			// Bottom wall
			for (int i = cmin; i <= cmax; i++) {
				shellArray[counter] = arr[rmax][i];
				counter++;
			}
			rmax--;
			// Right Wall
			for (int i = rmax; i >= rmin; i--) {
				shellArray[counter] = arr[i][cmax];
				counter++;
			}
			cmax--;
			// Top Wall
			for (int i = cmax; i >= cmin; i--) {
				shellArray[counter] = arr[rmin][i];
				counter++;
			}
		}

		//Sortings.Display(shellArray);
		System.out.println();
		rotateArray(shellArray, d);
		
		rmin = 0;
		cmin = 0;
		rmin = rmin + (sno - 1);
		rmax = arr.length - (sno);
		cmin = cmin + (sno - 1);
		cmax = arr[0].length - (sno);
		counter = 0;
		
		for(int i = rmin; counter < noOfItems && i <= rmax; i++) {
			arr[i][cmin] = shellArray[counter];
			counter++;
		}
		cmin++;
		//Bottom wall
		for(int i = cmin; counter < noOfItems && i <= cmax; i++) {
			arr[rmax][i] = shellArray[counter];
			
			counter++;
		}
		rmax--;
		// Right Wall
		for(int i = rmax; counter < noOfItems && i >= rmin; i--) {
			arr[i][cmax] = shellArray[counter];
			
			counter++;
		}
		cmax--;
		// Top Wall
		for(int i = cmax;counter < noOfItems && i >= cmin; i--) {
			arr[rmin][i] = shellArray[counter];
			
			counter++;
		}
		rmin++;
		
		for(int i = 0; i< arr.length; i++) {
			for(int j = 0; j< arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void rotateArray(int[] arr, int d) {
		reverseArray(arr, arr.length - d, arr.length - 1);
		reverseArray(arr, 0, arr.length - d -1);
		reverseArray(arr, 0, arr.length-1);
		//Sortings.Display(arr);                                   
	}

	public static void reverseArray(int[] arr,int left,int right) {
		while(left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
}
