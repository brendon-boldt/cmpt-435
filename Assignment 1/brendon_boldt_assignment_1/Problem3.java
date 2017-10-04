import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Problem3 {
	
	// Simple swap method
	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static boolean rearrange(int[] A) {
		/*
		Input: an array, A, of n sorted integers (positive, negative, or 0) that 
		A[0] <= A[1] <= A[2] <= A[n-2] <= A[n-1]

		Output: re-arrange elements in A such that: 
		Element at even position (i.e., A[0], A[2]) are less than or equal to
		both of its neighbors
		Element at odd position (i.e., A[1], A[3]) are greater than or equal to
		both of its neighbors

		A[0] <= A[1] >= A[2] <= A[3] >= A[4] <= A[5]�

		Design an algorithm that solves this problem in O(n) time.
		 */

		for (int i = 0; i < A.length; ++i) {
			// If element is odd (and not the last element) swap it with the
			// following element such that A[i] is now greater than A[i+1].
			if (i % 2 == 1 && i+1 < A.length)
				swap(A, i, i+1);
		}
		
		return true;
	}
	
	// Check that the array matches the postconditions
	public static boolean check(int[] A) {
		if (A.length < 2)
			return true;
		for (int i = 1; i < A.length-1; i += 2) {
			if (A[i-1] > A[i] || A[i+1] > A[i])
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
			int[] A = randomArray(100, 0, 100);
			Arrays.sort(A);
			rearrange(A);
			if (!check(A)) {
				System.out.printf("Failed; array: %s\n", Arrays.toString(A));
			}
		}
		System.out.println("Done");
	}

}
