package hw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class Untitled {
    public static void main(String[] args) {
	ArrayList<Integer> arrList = new ArrayList<Integer>();
	LinkedList<Integer> linkList = new LinkedList<Integer>();

	for (int i = 0; i < 10000; i++) {
	    arrList.add(i);
	    linkList.add(i);
	}

//		System.out.println(arrList);
//		System.out.println(linkList);

	long startTime = System.nanoTime();
	removeFirstHalf(arrList);
	long finishTime = System.nanoTime();
	System.out.println("ArrList for loop: \t" + (finishTime - startTime));

	startTime = System.nanoTime();
	removeFirstHalf(linkList);
	finishTime = System.nanoTime();
	System.out.println("LinkList for loop: \t" + (finishTime - startTime));

	arrList = new ArrayList<Integer>();
	linkList = new LinkedList<Integer>();

	for (int i = 0; i < 10000; i++) {
	    arrList.add(i);
	    linkList.add(i);
	}

	startTime = System.nanoTime();
	removeFirstHalfIterator(arrList);
	finishTime = System.nanoTime();
	System.out.println("ArrList iterator: \t" + (finishTime - startTime));

	startTime = System.nanoTime();
	removeFirstHalfIterator(linkList);
	finishTime = System.nanoTime();
	System.out.println("LinkList iterator: \t" + (finishTime - startTime));

	System.out.println();

	arrList = new ArrayList<Integer>();
	linkList = new LinkedList<Integer>();

	for (int i = 0; i < 1000000; i++) {
	    arrList.add(i);
	    linkList.add(i);
	}

	startTime = System.nanoTime();
	removeFirstHalf(arrList);
	finishTime = System.nanoTime();
	System.out.println("ArrList for loop: \t" + (finishTime - startTime));

	startTime = System.nanoTime();
	removeFirstHalf(linkList);
	finishTime = System.nanoTime();
	System.out.println("LinkList for loop: \t" + (finishTime - startTime));

	arrList = new ArrayList<Integer>();
	linkList = new LinkedList<Integer>();

	for (int i = 0; i < 1000000; i++) {
	    arrList.add(i);
	    linkList.add(i);
	}

	startTime = System.nanoTime();
	removeFirstHalfIterator(arrList);
	finishTime = System.nanoTime();
	System.out.println("ArrList iterator: \t" + (finishTime - startTime));

	startTime = System.nanoTime();
	removeFirstHalfIterator(linkList);
	finishTime = System.nanoTime();
	System.out.println("LinkList iterator: \t" + (finishTime - startTime));

    }

    public static void removeFirstHalf(List<Integer> lst) {
	int theSize = lst.size() / 2;
	for (int i = 0; i < theSize; i++)
	    lst.remove(0);
    }

    public static void removeFirstHalfIterator(List<Integer> lst) {
	int theSize = lst.size() / 2;
	ListIterator<Integer> iter = lst.listIterator();

	for (int i = 0; i < theSize; i++) {
	    iter.next();
	    iter.remove();
	}
    }

}