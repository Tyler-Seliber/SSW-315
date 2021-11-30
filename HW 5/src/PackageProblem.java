import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PackageProblem {

    public static void main(String[] args) {
	// Create an ArrayList of items with varying weights
	ArrayList<Item> items = new ArrayList<Item>();
	items.add(new Item(0.6));
	items.add(new Item(0.4));
	items.add(new Item(0.7));
	items.add(new Item(0.1));
	items.add(new Item(0.6));
	items.add(new Item(0.9));
	items.add(new Item(1.0));
	items.add(new Item(0.4));
	items.add(new Item(0.7));
	items.add(new Item(0.5));

	// Create a priority queue for the boxes
	PriorityQueue<Box> boxes = new PriorityQueue<Box>();

	// Package the items in as few boxes as possible
	packageItems(items, boxes);

	System.out.println("Boxes of unsorted items:");
	printBoxes(boxes);

	// Sort the array of items
	Collections.sort(items, new ItemComparator());

	// Create a new priority queue for the boxes of sorted items
	PriorityQueue<Box> sortedBoxes = new PriorityQueue<Box>();

	// Package the sorted items in as few boxes as possible
	packageItems(items, sortedBoxes);

	System.out.println("\nBoxes of sorted items:");
	printBoxes(sortedBoxes);
    }

    /*
     * Put each item into the box with the highest load it can fit in
     */
    public static void packageItems(ArrayList<Item> items, PriorityQueue<Box> boxes) {
	for (Item i : items) {
	    // Create new PriorityQueue to store checked boxes
	    Queue<Box> checkedBoxes = new PriorityQueue<Box>();
	    while (!boxes.isEmpty()) {
		// Add item to first available box from priority queue if it'll fit.
		if (boxes.peek().addItem(i))
		    break;
		// Add current box to checkedBoxes and check the next available box
		else {
		    checkedBoxes.add(boxes.poll());
		}
	    }
	    // If all boxes have been checked, create a new box to store this item and add
	    // it to the priority queue
	    if (boxes.isEmpty()) {
		Box newBox = new Box();
		newBox.addItem(i);
		boxes.add(newBox);
	    }
	    // Transfer all checked boxes back into the priority queue
	    while (!checkedBoxes.isEmpty()) {
		boxes.add(checkedBoxes.poll());
	    }
	}
    }

    /*
     * Print the contents of each box
     */
    public static void printBoxes(PriorityQueue<Box> boxes) {
	int n = 1;
	while (!boxes.isEmpty()) {
	    Box b = boxes.poll();
	    System.out.println("Box " + n + ":");
	    for (Item i : b.getItems())
		System.out.println("\t " + i.getWeight());
	    System.out.println("\t+___");
	    System.out.println("\t " + b.getLoad());
	    n++;
	}
    }

}
