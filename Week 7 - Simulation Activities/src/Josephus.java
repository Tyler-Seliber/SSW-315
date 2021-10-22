import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public final class Josephus {
    /**
     * Return the winner in the Josephus problem. Linked list implementation. (Can
     * replace with ArrayList or TreeSet).
     */
    public static int jos1(int people, int passes) {
	Collection<Integer> theList = new LinkedList<Integer>();

	// Construct the list
	for (int i = 1; i <= people; i++)
	    theList.add(i);

	// Play the game;
	Iterator<Integer> itr = theList.iterator();
	while (people-- != 1) {
	    for (int i = 0; i <= passes; i++) {
		if (!itr.hasNext())
		    itr = theList.iterator();

		itr.next();
	    }
	    itr.remove();
	}

	itr = theList.iterator();

	return itr.next();
    }

    // main() to test;
    public static void main(String[] args) {
	String str = "";
	int n, m = 0;
	Scanner scanner = new Scanner(System.in);

	System.out.println("Please input the number of people in the circle (>0): ");
	str = scanner.nextLine();
	n = Integer.parseInt(str);

	System.out.println("Please input the killing interval (>0): ");
	str = scanner.nextLine();
	m = Integer.parseInt(str);

	System.out.println("JOS1: " + jos1(n, m));
    }
}