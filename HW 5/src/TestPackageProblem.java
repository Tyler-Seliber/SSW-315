import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class TestPackageProblem {

    @Test
    void test() {
	// Create an ArrayList of items with varying weights
	ArrayList<Item> items = new ArrayList<Item>();
	// Make a random number of items that need to be packaged
	int n = (int) (Math.random() * (100 - 5) + 5);
	// Create items of random weights
	for (int i = 0; i < n; i++) {
	    float r = (float) Math.random();
	    items.add(new Item(r));
	}

	// Create a priority queue for the boxes
	PriorityQueue<Box> boxes = new PriorityQueue<Box>();

	// Package the items in as few boxes as possible
	PackageProblem.packageItems(items, boxes);

	// Test that the load of each box is less than their maximum capacity
	while (!boxes.isEmpty()) {
	    Box b = boxes.poll();
	    assertTrue(b.getLoad() <= b.getCapacity());
	}

	// Sort the array of items
	Collections.sort(items, new ItemComparator());

	// Create a new priority queue for the boxes of sorted items
	PriorityQueue<Box> sortedBoxes = new PriorityQueue<Box>();

	// Package the sorted items in as few boxes as possible
	PackageProblem.packageItems(items, sortedBoxes);

	// Test that the load of each box is less than their maximum capacity
	while (!sortedBoxes.isEmpty()) {
	    Box b = sortedBoxes.poll();
	    assertTrue(b.getLoad() <= b.getCapacity());
	}

    }
}
