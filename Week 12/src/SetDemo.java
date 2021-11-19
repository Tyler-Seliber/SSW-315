import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String args[]) {
	int count[] = { 34, 22, 10, 60, 30, 22 };
	ArrayList<Integer> arrList = new ArrayList<Integer>();

	Set<Integer> set = new HashSet<>();

	for (int i = 0; i < count.length; i++) {
	    arrList.add(count[i]); // add int values as integer objects into the collection

	    set.add(count[i]); // automatically ignores duplicates when adding
	}

	System.out.println("Content of the arrList is " + arrList);
	System.out.println("Content of the set is " + set);

	TreeSet<Integer> set2 = new TreeSet<>(set); // build a tree set from the hash set
	System.out.println("Content of the TreeSet is " + set2);

	System.out.println("The first element of the set is " + set2.first());
	System.out.println("The last element of the set is " + set2.last());

//	Set<Integer> set = new HashSet<Integer>();
//
//	try {
//	    for (int i = 0; i < 6; i++) {
//		set.add(count[i]); // add to set
//		alist.add(count[i]); // add to array list
//	    }
//	    System.out.println(set);
//	    System.out.println(alist);
//
//	    int numUniq = new HashSet(alist).size();
//	    System.out.println("Unique number is alist is: " + numUniq);
//
//	    TreeSet sortedSet = new TreeSet<Integer>(set);
//	    System.out.println("The sorted list is:");
//	    System.out.println(sortedSet);
//
//	    System.out.println("The First element of the set is: " + (Integer) sortedSet.first());
//	    System.out.println("The last element of the set is: " + (Integer) sortedSet.last());
//	} catch (Exception e) {
//	}
//
//	/*
//	 * String[] listA = {"Ann", "Sally", "Jill", "Sally"}; String[] listB = {"Bob",
//	 * "Bill", "Ann", "Jill"}; Set<String> setA = new HashSet<String>(); Set<String>
//	 * setAcopy = new HashSet<String>(); Set<String> setB = new HashSet<String>();
//	 * 
//	 * // Load sets from arrays. for (String s:listA) { setA.add(s);
//	 * setAcopy.add(s); }
//	 * 
//	 * for (String s:listB) { setB.add(s); }
//	 * 
//	 * System.out.println("The 2 sets are: " + "\n" + setA + "\n" + setB);
//	 * 
//	 * // Display the union and intersection. setA.addAll(setB); // Set union
//	 * setAcopy.retainAll(setB); // Set intersection
//	 * 
//	 * System.out.println("Items in set union are: " + setA);
//	 * System.out.println("Items in set intersection are: " + setAcopy);
//	 */
    }
}