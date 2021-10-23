import java.util.ArrayList;

class Recursive {
    private static ArrayList<Integer> list = new ArrayList<Integer>();
    private static ArrayList<Integer> reversedList = new ArrayList<Integer>();

    // this one builds a list containing values from 1 to n
    public static ArrayList<Integer> buildList(int n) {
	// write this in terms of a recursive call using a smaller n
	ArrayList<Integer> tempList = null;
	if (n <= 0) { // base case: build an empty list;
	    return new ArrayList<Integer>();
	} else { // recursive case: build a list with n-1 items, then append n at the end of the
	    // list;
	    tempList = buildList(n - 1);
	    tempList.add(n);
	    return tempList;
	}
    }

    // this one reverses a list in-place
    public static ArrayList<Integer> reverse(ArrayList<Integer> lst) {
	// write this in terms of a recursive call using a smaller lst

	ArrayList<Integer> temp = buildList(lst.size());
	lst.clear();
	// base case
	if (temp.size() == lst.size())
	    return lst;

	lst.add(temp.get(temp.size() - 1));
	ArrayList<Integer> tail = new ArrayList<Integer>(temp.subList(0, temp.size() - 1));
	lst.addAll(reverse(tail));
	return lst;

    }

    // return the sum of all Integers in the ArrayList; this should not change the
    // lst argument
    public static Integer add(ArrayList<Integer> lst) {
	return add(lst, 0);
    }

    // Print out all the contents of the argument; this should not change the lst
    // argument
    public static void print(ArrayList<Integer> lst) {
	System.out.print("[");
	print(lst, 0);
	System.out.println("]");
	return;
    }

    private static Integer add(ArrayList<Integer> lst, int index) {
	// think of the input is the inclusive sublist of elements from index
	// to lst.size(). make this sublist shorter in the recursive call
	// by incrementing index
	int sum = 0;
	if (index == lst.size() - 1) {
	    sum += lst.get(index);
	} else
	    sum += lst.get(index) + add(lst, index + 1);
	return sum;
    }

    private static void print(ArrayList<Integer> lst, int index) {
	// write this in the same way as add, above
	if (index == lst.size() - 1) {
	    System.out.print(lst.get(index));
	} else {
	    System.out.print(lst.get(index) + ", ");
	    print(lst, index + 1);
	}
    }

    public static void main(String[] args) {
	ArrayList<Integer> lst = Recursive.buildList(5);
	Recursive.print(lst);
	System.out.println();
	System.out.println("The list printed in forward order: " + lst);
	reverse(lst);
	System.out.println("The list printed in reverse order: " + lst);
	System.out.println("The sum of all values from the list is: " + Recursive.add(lst));
    }
}