package lab5;

public class MyDLLImpl<E> implements MyDoubleLinkedList {

    private MyDoubleNode head;
    private MyDoubleNode tail;
    private int size;

    public MyDLLImpl() {
	this.head = null;
	this.tail = null;
	this.size = 0;
    }

    @Override
    // Insert a new node at the end of the list
    public void insert(Object x) {
	MyDoubleNode newNode = new MyDoubleNode(x, null, tail);

	if (isEmpty()) {
	    head = newNode;
	    tail = newNode;
	}

	tail.next = newNode;
	tail = newNode;
	size++;

    }

    // Insert a new node after node a
    public void insert(Object x, MyDoubleNode a) {
	MyDoubleNode newNode = new MyDoubleNode(x, a, a.next);

	if (isEmpty()) {
	    head = newNode;
	    tail = newNode;
	}
	// Check if inserting at the end
	if (a == tail) {
	    insert(x);
	    return;
	}
	a.next.prev = newNode;
	a.next = newNode;
	size++;

    }

    @Override
    public void delete(Object x) {
	if (isEmpty()) {
	    return;
	}
	MyDoubleNode current = head;
	while (current != null) {
	    if (current.data == x) {
		// If current is the head
		if (current.prev == null) {
		    current.next.prev = null;
		    head = current.next;
		}
		// If current is the tail
		else if (current.next == null) {
		    current.prev.next = null;
		    tail = current.prev;
		}
		// If current is an intermediary node
		else {
		    current.prev.next = current.next;
		    current.next.prev = current.prev;
		}
		size--;
		return;
	    }
	    current = current.next;
	}
    }

    @Override
    public boolean lookup(Object x) {
	if (isEmpty()) {
	    return false;
	}

	MyDoubleNode current = head;
	while (current != null) {
	    if (current.data == x) {
		return true;
	    }
	    current = current.next;
	}
	return false;
    }

    @Override
    public boolean isEmpty() {
	return this.size == 0;
    }

    @Override
    public void printList() {
	if (isEmpty()) {
	    System.out.println("List is empty.");
	    return;
	}

	MyDoubleNode current = head;
	while (current != null) {
	    System.out.print(current.data + " ");
	    current = current.next;
	}

	System.out.println();

    }

    @Override
    public void printListRev() {
	if (isEmpty()) {
	    System.out.println("List is empty.");
	    return;
	}

	MyDoubleNode current = tail;
	while (current != null) {
	    System.out.print(current.data + " ");
	    current = current.prev;
	}
	System.out.println();
    }

    public int getSize() {
	return this.size;
    }

    public static void main(String a[]) {
	MyDLLImpl<Integer> dll = new MyDLLImpl<Integer>();
	dll.insert(10);
	dll.insert(34);
	dll.insert(56);
	dll.insert(364);
	dll.printList();
	dll.printListRev();
	System.out.println(dll.getSize());
	dll.delete(56);
	dll.delete(34);
	dll.printList();
	System.out.println(dll.getSize());
	System.out.println(dll.lookup(10));
	System.out.println(dll.lookup(34));
	dll.printListRev();
    }

}
