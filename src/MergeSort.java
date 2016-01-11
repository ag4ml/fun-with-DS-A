import java.util.Arrays;

public class MergeSort {
	/** Sort an array of integers using mergesort **/

	public static void mergeSort(int[] A) {
		mergeSort(A, 0, A.length - 1);
	}

	private static void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(A, l, m);
			mergeSort(A, m + 1, r);
			merge(A, l, m, r);
		}
	}

	private static void merge(int[] A, int l, int m, int r) {
		int[] left = new int[m - l + 2];
		int[] right = new int[r - m + 1];
		for (int i = l; i <= m; i++)
			left[i - l] = A[i];
		for (int i = m + 1; i <= r; i++)
			right[i - m - 1] = A[i];
		left[left.length - 1] = Integer.MAX_VALUE;
		right[right.length - 1] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = l; k <= r; k += 1) {
			if (left[i] < right[j]) {
				A[k] = left[i];
				i += 1;
			} else {
				A[k] = right[j];
				j += 1;
			}
		}

	}

	public static void main(String[] args) {
		// Try out mergeSort
		int[] myArray = new int[25];
		for(int i=0; i<myArray.length; i+=1){
			myArray[i] = (int) (Math.random()*100);
		}
		System.out.println("Unsorted version: ");
		System.out.println(Arrays.toString(myArray));
		mergeSort(myArray);
		System.out.println("Sorted version: ");
		System.out.println(Arrays.toString(myArray));

	}

}
