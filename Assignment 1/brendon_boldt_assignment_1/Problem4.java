import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Problem4 {

	// Simple swap function
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}



	public static void partition(int[] A) {
		/*
		Let x = A[0]
		Re-arrange elements in A, so that after the re-arrangement, suppose x
		is in position i, that is A[i] = x, you should have A[j] <= x for all 
		j < i and A[j] > x for all j > i. Thus, informally, all the values to 
		the "left" of x are less than (or equal to) x and all values to the
		 right are larger than x.
		*/

		if (A.length == 0)
			return;
		
		// Let the first element be the "pivot" for the partition
		int pivot = A[0];
		// i marks the lower end of the partition (A[i] <= pivot)
		int i = 1;
		// i marks the upper end of the partition (A[j] > pivot)
		int j = A.length - 1;
		// Continue process until fully partitioned
		while (i < j) {
			if (A[i] <= pivot)
				++i;
			else {
				// Swap the element at A[i] into the upper partition
				swap(A, i, j);
				// Swapped element is now correctly in the upper partition
				--j;
			}
		}

		// Put the first element in the correct place
		if (A.length > 1 && pivot > A[i]) {
			swap(A, 0, i);
		} else {
			swap(A, 0, i-1);
		}
		
	}

	// Check that the array matches the postconditions
	
	public static boolean check(int[] A, int pivot) {
		boolean hi = true;
		for (int i = A.length-1; i >= 0; --i) {
			if (A[i] == pivot)
				hi = false;

			if (hi && A[i] <= pivot)
				return false;
			if (!hi && A[i] > pivot)
				return false;
		}
		return true;
	}
	

	public static int[] randomArray(int maxSize, int lo, int hi) {
		int[] A = new int[ThreadLocalRandom.current().nextInt(1, maxSize+1)];
		for (int i = 0; i < A.length; ++i)
			A[i] = ThreadLocalRandom.current().nextInt(lo, hi);
		return A;
	}
	
	public static void main(String[] args) {
		int testSize = 100000;
		for (int i = 0; i < testSize; ++i) {
			int[] A = randomArray(10, 0, 100);
			int pivot = A[0];
			partition(A);
			if (!check(A, pivot)) {
				System.out.printf("Failed; pivot: %d, array: %s\n", pivot, Arrays.toString(A));
			}
		}
		System.out.println("Done");
	}
}
