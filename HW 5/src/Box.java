import java.util.ArrayList;

public class Box implements Comparable<Box> {
    private float capacity;
    private float load;
    private ArrayList<Item> items;

    public Box() {
	capacity = (float) 1.0;
	load = (float) 0.0;
	items = new ArrayList<Item>();
    }

    public float getCapacity() {
	return capacity;
    }

    public float getLoad() {
	return load;
    }

    public ArrayList<Item> getItems() {
	return items;
    }

    /* Check if item fits, add it to the box if so */
    public boolean addItem(Item i) {
	if (i.getWeight() + load <= capacity) {
	    items.add(i);
	    load += i.getWeight();
	    return true;
	}
	return false;
    }

    @Override
    public int compareTo(Box b) {
	if (load > b.load)
	    return -1;
	return 1;
    }

}
