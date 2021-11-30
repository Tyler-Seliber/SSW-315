import java.util.Comparator;

/* 
 * Class that implements Comparator interface to sort the ArrayList of Items from heaviest to lightest.
 */

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item i1, Item i2) {
	if (i1.getWeight() == i2.getWeight())
	    return 0;
	else if (i1.getWeight() < i2.getWeight())
	    return 1;
	else
	    return -1;
    }

}
