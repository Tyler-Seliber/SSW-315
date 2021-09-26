public class MyLinkedList { // Start of class MyLinkedList
    private Node first;
    private Node last;

    // LinkList constructor
    public MyLinkedList() {
	first = null;
	last = null;

    }

    // Returns true if the linked list is empty
    public boolean isEmpty() {
	return first == null;

    }

    // Inserts a new node at the first of the linked list
    public void addFirst(int d1, double d2) {
	Node node = new Node(d1, d2);
	node.next = first;
	first = node;
    }

    // Inserts a new node at the last of the linked list
    public void addLast(int d1, double d2) {
	Node node = new Node(d1, d2);
	node.next = last;
	last = node;
    }

    // Deletes the node at the first of the linked list
    public Node deleteFirst() {
	Node temp = first;
	first = first.next;
	return temp;
    }

    // Deletes the node at the last of the linked list
    public Node deleteLast() {
	Node temp = last;
	last = last.next;
	return temp;
    }

    // Count the number of nodes in the linked list
    public int size() {
	Node currentNode = first;
	int nodes = 0;
	while (currentNode != null) {
	    nodes++;
	    currentNode = currentNode.next;
	}
	return nodes;
    }

    // Prints the linked list data
    public void printList() {
	Node currentNode = first;
	System.out.print("List: ");
	while (currentNode != null) {
	    currentNode.printNode();
	    currentNode = currentNode.next;
	}
	System.out.println("");

    }
} // End of class LinkList