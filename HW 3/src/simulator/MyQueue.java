package simulator;

public class MyQueue<E> {
    // Node class for single linked list queue
    private static class Node<E> {
	// Instance variables for Node
	private E data;
	private Node next;

	// Constructor for Node, to be completed by you
	private Node(E dataItem) {
	    this.data = dataItem;
	    this.next = null;
	}

	// Constructor for Node, to be completed by you
	private Node(E dataItem, Node<E> nodeRef) {
	    this.data = dataItem;
	    this.next = nodeRef;
	}
    }

    // Instance variables for queue
    private Node<E> front;
    private Node<E> rear;
    private int size;

    // Constructor for queue, to be completed by you
    public MyQueue() {
	this.front = null;
	this.rear = null;
	this.size = 0;
    }

    // Adds a node to queue, to be completed by you
    public boolean offer(E item) {

	Node<E> n = new Node<E>(item);
	if (size == 0) {
	    front = n;
	} else {
	    rear.next = n;
	}
	rear = n;
	size++;
	return true;
    }

    // Returns the node at front of queue, to be completed by you
    public E peek() {
	if (size == 0) {
	    return null;
	}
	return front.data;
    }

    // Returns and removes the node at front of queue, to be completed by you
    public E poll() {
	if (size == 0) {
	    return null;
	}

	E data = front.data;
	if (size == 1) {
	    front = null;
	    rear = null;
	} else {
	    front = front.next;
	}
	size--;
	return data;
    }

    // Returns the data element at a specific index, to be completed by you
    public E get(int index) {
	if (size == 0) {
	    return null;
	}
	if (index > size - 1 || index < 0) {
	    return null;
	}
	Node<E> current = front;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}
	return current.data;
    }

    // Returns the size of the queue, to be completed by you
    public int size() {
	return size;
    }

    // Returns the data from the final node of the queue
    public E getRear() {
	return rear.data;
    }
}
