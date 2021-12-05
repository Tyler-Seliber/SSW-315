import java.util.Arrays;

/**
 * Modify this implementation of Quicksort. Change the private method
 * quicksort() so it is implemented WITHOUT the two vectors, and in their places
 * uses a single array named "extra".
 * 
 */
public class QuicksortLab {
    int[] items = new int[100];

    public void quickSort(int[] arrayToSort) {
	items = arrayToSort;
	quicksort(0, items.length - 1);
	for (int index = 0; index <= items.length - 1; index++) {
	    System.out.print(items[index] + " ");
	}
	System.out.println();
    }

    /*
     * Quick sort implementation using an array
     */
    private void quicksort(int from, int to) {
	// Use first element as pivot point
	int pivot = from;
	int pivotValue = items[pivot];

	// Print current iteration of array
	System.out.print("(" + from + "," + to + ") ");
	for (int index = from; index <= to; index++) {
	    System.out.print(items[index] + " ");
	}
	System.out.println();

	// Keep track of values less than (to the left of) the pivot
	int left = from + 1;
	for (int i = from; i <= to; i++)
	    if (i != pivot)
		// If current item is less than the pivot value, swap it to the left side of the
		// array
		if (items[i] < pivotValue)
		    swap(i, left++);

	// Put pivot in the middle of the array
	swap(pivot, left - 1);
	pivot = left - 1;

	// Quick sort left half (before pivot)
	if (pivot > from + 1)
	    quicksort(from, pivot - 1);
	// Quick sort right half (after pivot)
	if (pivot < to - 1)
	    quicksort(pivot + 1, to);

    }

    /*
     * Helper method to swap two elements in items array
     */
    private void swap(int a, int b) {
	int temp = items[a];
	items[a] = items[b];
	items[b] = temp;
    }

    public static void main(String[] args) {
	int[] arr = { 44, 75, 23, 43, 55, 12, 64, 77, 33 }; // a test input array
	System.out.println("Original array: " + Arrays.toString(arr));
	QuicksortLab qs = new QuicksortLab();
	qs.quickSort(arr);
	System.out.println("Sorted array: " + Arrays.toString(arr));

    }
}
