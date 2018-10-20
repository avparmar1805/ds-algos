package feb11;

public class sortings {

	public static void main(String[] args) {
		int[] arr = {55, 22, 10, 73, 95};
		
		feb10.WorkWithArrays.display(arr);
		insertionSort(arr);
		feb10.WorkWithArrays.display(arr);
	}
	
	public static void bubbleSort(int[] arr){
		int journeyCounter = 1;
		while(journeyCounter <= arr.length - 1){
			for(int i = 0; i < arr.length - journeyCounter; i++){
				if(arr[i] > arr[i + 1]){
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			
			journeyCounter++;
		}
	}

	public static void selectionSort(int[] arr){
		int journeyCounter = 1;
		while(journeyCounter <= arr.length - 1){
			for(int i = journeyCounter; i < arr.length; i++){
				if(arr[journeyCounter - 1] > arr[i]){
					int temp = arr[journeyCounter - 1];
					arr[journeyCounter - 1] = arr[i];
					arr[i] = temp;
				}
			}
			
			journeyCounter++;
		}
	}
	
	public static void insertionSort(int[] arr){
		int journeyCounter = 1;
		while(journeyCounter <= arr.length - 1){
			for(int i = journeyCounter; i > 0; i--){
				if(arr[i - 1] > arr[i]){
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				} else {
					break;
				}
			}
			
			journeyCounter++;
		}
	}
	
}
