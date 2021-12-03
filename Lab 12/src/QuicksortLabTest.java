import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class QuicksortLabTest {

    @Test
    void testQuickSort() {
	int[] input1 = { 44, 75, 23, 43, 55, 12, 64, 77, 33 }; // a test input array
	QuicksortLab qs = new QuicksortLab();
	qs.quickSort(input1);
	String expected1 = "[12, 23, 33, 43, 44, 55, 64, 75, 77]"; // expected results from quicksort()
	assertEquals(expected1, Arrays.toString(input1));
    }

}
