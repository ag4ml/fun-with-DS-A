import java.util.Arrays;

public class QuickSort {
	/** Sorting an array of integers using quicksort **/
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(array, left, right);
			quickSort(array, left, partitionIndex - 1);
			quickSort(array, partitionIndex + 1, right);
		}
	}

	private static int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int i = left - 1;
		for (int j = left; j < right; j += 1) {
			if (array[j] < pivot) {
				i += 1;
				swap(array, i, j);
			}
		}
		swap(array, right, i + 1);
		return i + 1;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}

	public static void main(String[] args) {
		// Try out the algo
		int[] myArray = new int[20];
		for (int i = 0; i < myArray.length; i += 1)
			myArray[i] = (int) (Math.random() * 100);
		System.out.println("Unsorted version: ");
		System.out.println(Arrays.toString(myArray));
		quickSort(myArray);
		System.out.println("Sorted version: ");
		System.out.println(Arrays.toString(myArray));

	}

}
