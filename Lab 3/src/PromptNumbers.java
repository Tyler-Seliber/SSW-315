import java.util.Scanner;

/*This program prompts the user to enter several numbers,
stores the numbers into an array,
then prints the numbers in forwards and backwards order.

Expected example output:

How many numbers will you enter? 4
Type a number: 12
Type a number: 8
Type a number: -2
Type a number: 39

Your numbers in forward order:
12
8
-2
39

Your numbers in backward order:
39
-2
8
12
 */

public class PromptNumbers {
    public static void main(String[] args) {
	Scanner console = new Scanner(System.in);
	System.out.print("How many numbers will you enter? ");
	int count = console.nextInt();

	// Create an array to store the entered numbers
	int[] num_input = new int[count];

	//// Store the numbers
	for (int i = 0; i < count; i++) {
	    System.out.print("Type a number: ");
	    num_input[i] = console.nextInt();

	}

	System.out.println();
	System.out.println("Your numbers in forward order:");

	// Print the numbers in forward order
	for (int i = 0; i < num_input.length; i++) {
	    System.out.println(num_input[i]);

	}

	System.out.println();
	System.out.println("Your numbers in backward order:");

	// Print the numbers in backward order
	for (int i = num_input.length - 1; i >= 0; i--) {
	    System.out.println(num_input[i]);
	}

	// Print the array in forward order, pass the array as input
	printArray(num_input);

    }

    public static void printArray(int[] arr) {
	System.out.println("Your numbers in forward order:");
	for (int i : arr) {
	    System.out.println(i);
	}
    }
}