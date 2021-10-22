import java.util.ArrayList;

public class Recursive {
    // this one builds a list containing values from 1 to n
    public static ArrayList<Integer> buildList(int n) {
	// write this in terms of a recursive call using a smaller n
	return null;
    }

    // this one reverses a list in-place
    public static void reverse(ArrayList<Integer> lst) {
	// write this in terms of a recursive call using a smaller lst
    }

    // return the sum of all Integers in the ArrayList; this should not change the
    // lst argument
    public static Integer add(ArrayList<Integer> lst) {
	return add(lst, 0);
    }

    // Print out all the contents of the argument; this should not change the lst
    // argument
    public static void print(ArrayList<Integer> lst) {
	print(lst, 0);
	return;
    }

    private static Integer add(ArrayList<Integer> lst, int index) {
	// think of the input is the inclusive sublist of elements from index
	// to lst.size(). make this sublist shorter in the recursive call
	// by incrementing index
	return null;
    }

    private static void print(ArrayList<Integer> lst, int index) {
	// write this in the same way as add, above
    }

    public static void main(String[] args) {
	ArrayList<Integer> lst = Recursive.buildList(5);
	Recursive.print(lst);
	System.out.println("+---");
	System.out.println(Recursive.add(lst));
    }
}