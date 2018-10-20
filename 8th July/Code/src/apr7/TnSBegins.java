package apr7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TnSBegins {

	public static void main(String[] args) {

		// int[] one = { 10, 20, 30, 40, 50 };
		// int[] two = { 11, 15, 21, 25, 29, 35 };
		// int[] result = mergeTwoSortedArrays(one, two);
		//

//		int[] result = { 10, 55, 2, 99, 8, 77, 33, -5 };
//		result = mergeSort(result, 0, result.length - 1);
//		for (int val : result) {
//			System.out.print(val + " ");
//		}
		
//		int n = 1000000;
//		
//		long start = System.currentTimeMillis();
//		
//		int[] arr = new int[n];
//		mergeSort(arr, 0, arr.length - 1);
//		bubbleSort(arr);
//		
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
		
//		System.out.println(getPolyVal(2, 3));
//		int[] arr = {55, 8, 6, 55, 3, 6, 8};
//		System.out.println(getUnique(arr));
		
//		int[] arr = {3, 5, 1, 2, 4, 3};
//		System.out.println(getMissing(arr));
//		sieve(30);
//		int[] arr = {2, 2, 1, 0, 1, 0, 1, 2, 2, 0, 1, 1, 2, 0, 1};
//		sort012(arr);
		
//		int[] arr = {0, 0, 0, 0, 0, 5, 6, 7, 8, 9};
//		moveZeros(arr);
//		for(int val: arr) {
//			System.out.print(val + " ");
//		}
//		System.out.println(".");
//		highestFrequencyCharacter("harharmodighargharmodi");
		
		int[] arr = {45, 21, 33, 67, 88};
		Arrays.sort(arr); // dual pivoted quick sort + insertion sort
		for(int val: arr) {
			System.out.print(val + " ");
		}
		System.out.println(".");
		
		ArrayList<Integer> list = new ArrayList<>();
		Collections.sort(list);
	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {
		int[] result = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				result[k] = one[i];
				i++;
				k++;
			} else {
				result[k] = two[j];
				j++;
				k++;
			}
		}

		while (j < two.length) {
			result[k] = two[j];
			j++;
			k++;
		}

		while (i < one.length) {
			result[k] = one[i];
			i++;
			k++;
		}

		return result;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}

		int mid = (lo + hi) / 2;
		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);
		int[] full = mergeTwoSortedArrays(fhalf, shalf);
		return full;
	}

	public static void bubbleSort(int[] arr) {
		int jc = 1;

		while (jc <= arr.length - 1) {
			for (int i = 0; i < arr.length - jc; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}

			jc++;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int getPolyVal(int x, int n) {
		int sum = 0;
		
		int coeffficient = n;
		int px = x;
		
		for(int i = 1; i <= n; i++) {
			sum += coeffficient * px;
			coeffficient--;
			px = px * x;
		}
		
		return sum;
	}

	public static int getUnique(int[] arr) {
		int rv = 0;
		
		for(int val: arr) {
			rv = rv ^ val;
		}
		
		return rv;
	}
	
	public static int getMissing(int[] arr) {
		int rv = 0;
		
		for(int i = 0; i < arr.length; i++) {
			rv = rv ^ i ^ arr[i];
		}
		
		return rv;
	}
	
	public static void sieve(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		primes[1] = false;
		
		for(int i = 0; i * i <= n; i++) {
			if(primes[i] == true) {
				for(int j = i; i * j <= n; j++) {
					primes[i * j] = false;
				}
			}
		}
		
		for(int i = 0; i < primes.length; i++) {
			if(primes[i] == true) {
				System.out.print(i + " ");
			}
		}
		System.out.println(".");
	}
	
	public static void sort01(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {
			if(arr[left] == 0 && arr[right] == 1) {
				left++;
				right--;
			} else if(arr[left] == 0) {
				left++;
			} else if(arr[right] == 1) {
				right--;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
	}
	
	public static void sort012(int[] arr) {
		int lo = 0; // from 0 to lo we are collecting 0's
		int mid = 0; // from lo to mid we are collecting 1's
		int hi = arr.length - 1; // from hi to arr.length - 1 we are collecting 2's
		// unknown area => mid to hi
		
		while(mid <= hi) {
			if(arr[mid] == 1) {
				mid++;
			} else if(arr[mid] == 2) {
				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;
				hi--;
			} else if(arr[mid] == 0) {
				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
			}
		}
	}
	
	public static void moveZeros(int[] arr) {
		int i = 0;
		int j = 0;
		
		while(i < arr.length) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			
			i++;
		}
	}

	public static void highestFrequencyCharacter(String str) {
		int[] fmap = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap[ch - 'a']++;
		}
		
		int maxF = 0;
		int maxFIdx = -1;
		
		for(int i = 0; i < fmap.length; i++) {
			if(fmap[i] > maxF) {
				maxF = fmap[i];
				maxFIdx = i;
			}
		}
		
		System.out.println((char)(maxFIdx + 'a'));
	}
	
	
}
