import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	/** Sorting an array of integers with d digits using radixsort **/

	public static void radixSort(int[] array, int d) {
		ArrayList<Integer>[] bins = (ArrayList<Integer>[]) new ArrayList[10];
		for (int i = 0; i < bins.length; i += 1)
			bins[i] = new ArrayList<Integer>();
		for (int i = 0; i < d; i += 1) {
			sortByIthDigit(array, bins, i);
		}
	}

	private static void sortByIthDigit(int[] array, ArrayList<Integer>[] bins,
			int i) {
		for (int k = 0; k < array.length; k += 1) {
			int digit = getIthDigit(array[k], i);
			bins[digit].add(array[k]);
		}
		int j = 0;
		for (ArrayList<Integer> bin : bins) {
			while (!bin.isEmpty()) {
				array[j] = bin.remove(0);
				j += 1;
			}
		}
	}

	private static int getIthDigit(int num, int i) {
		return (int) ((num % (Math.pow(10, i + 1))) / ((int) (Math.pow(10, i))));
	}

	public static boolean isSorted(int[] array) {
		for (int i = 1; i < array.length; i += 1) {
			if (array[i] < array[i - 1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] myArray = new int[20];
		for (int i = 0; i < myArray.length; i += 1) {
			myArray[i] = (int) (Math.random() * 800 + 100);
		}
		System.out.println("Presorted array: ");
		System.out.println(Arrays.toString(myArray));
		System.out.println("Sorted array: ");
		radixSort(myArray, 3);
		System.out.println(Arrays.toString(myArray));
		System.out.println("Is the array actually sorted?: ");
		System.out.println(isSorted(myArray));
	}

}
