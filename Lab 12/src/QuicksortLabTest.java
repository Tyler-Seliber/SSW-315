import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class QuicksortLabTest {

    @Test
    void testQuickSort() {

	QuicksortLab qs = new QuicksortLab();

	int[] input1 = { 44, 75, 23, 43, 55, 12, 64, 77, 33 }; // a test input array
	int[] valid1 = Arrays.copyOf(input1, input1.length);
	qs.quickSort(input1);

	String expected1 = "[12, 23, 33, 43, 44, 55, 64, 75, 77]"; // expected results from quicksort()
	assertEquals(expected1, Arrays.toString(input1));

	Arrays.sort(valid1);
	assertTrue(Arrays.equals(valid1, input1));

	int[] input2 = { 79, 82, 24, -97, -78, -6, -12, 13, 93, 91, -59, 43, 92, -91, -33, -80, -93, -5, 19, -88 };
	int[] expected2 = Arrays.copyOf(input2, input2.length);
	qs.quickSort(input2);
	Arrays.sort(expected2);
	assertTrue(Arrays.equals(expected2, input2));

	int[] input3 = { 98, -64, 28, -50, 7, 75, -57, 53, 79, 52, 84, 31, 55, -48, -83, -40, -44, -7, -19, 68 };
	int[] expected3 = Arrays.copyOf(input3, input3.length);
	qs.quickSort(input3);
	Arrays.sort(expected3);
	assertTrue(Arrays.equals(expected3, input3));

	int[] input4 = { 24, 57, 64, 3, 48, 70, -84, 83, 9, 53, 89, 6, -20, -24, 95, -58, -83, 92, -9, -75 };
	int[] expected4 = Arrays.copyOf(input4, input4.length);
	qs.quickSort(input4);
	Arrays.sort(expected4);
	assertTrue(Arrays.equals(expected4, input4));

	int[] input5 = { -90, -50, -41, -47, -94, -79, -22, -28, -89, -76, -85, -42, -75, -78, -56, -70, -68, -13, -37,
		-5 };
	int[] expected5 = Arrays.copyOf(input5, input5.length);
	qs.quickSort(input5);
	Arrays.sort(expected5);
	assertTrue(Arrays.equals(expected5, input5));

	int[] input6 = { -21, -44, -12, -33, -7, -70, -23, -20, -99, -15, -97, -46, -35, -10, -62, -32, -3, -88, -27,
		-52 };
	int[] expected6 = Arrays.copyOf(input6, input6.length);
	qs.quickSort(input6);
	Arrays.sort(expected6);
	assertTrue(Arrays.equals(expected6, input6));

	int[] input7 = { -21, -44, -12, -33, -7, -70, -23, -20, -99, -15, -97, -46, -35, -10, -62, -32, -3, -88, -27,
		-52 };
	int[] expected7 = Arrays.copyOf(input7, input7.length);
	qs.quickSort(input7);
	Arrays.sort(expected7);
	assertTrue(Arrays.equals(expected7, input7));

	int[] input8 = { 39, 17, -20, 10, 25, 5, -25 };
	int[] expected8 = Arrays.copyOf(input8, input8.length);
	qs.quickSort(input8);
	Arrays.sort(expected8);
	assertTrue(Arrays.equals(expected8, input8));

	int[] input9 = { 89, 44, -52, -71, -71, 44, -83, 45, 44, 64 };
	int[] expected9 = Arrays.copyOf(input9, input9.length);
	qs.quickSort(input9);
	Arrays.sort(expected9);
	assertTrue(Arrays.equals(expected9, input9));
    }

}
