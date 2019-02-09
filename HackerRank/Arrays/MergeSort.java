package Arrays;

public class MergeSort {

	
	public static void main() {
		
		int arr[] =  {2, 5,7,9};
		int arr2[] =  {1, 15,17,99};

		int [] mergedArr = mergeTwoArray(arr, arr2);
		for(int i : mergedArr) {
			System.out.print(""+i);
		}
	}
	
	public static int[] mergeTwoArray (int [] one, int[] two) {
		
		int merged[] = new int[one.length+two.length];
		
		int i=0, j = 0, k =0;
		
		if(one[i]<two[j]) {
			merged[k] = one[i];
			k++;
			i++;
		}
		else {
			merged[k]= two[j];
			k++;
			j++;
		}
		
		while(i<one.length) {
			merged[k] = one[i];
			k++;
			i++;
		}
		
		while(j<two.length) {
			merged[k]= two[j];
			k++;
			j++;
		}
		
		return merged;
	}
	
}
