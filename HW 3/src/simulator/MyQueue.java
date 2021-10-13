package simulator;

public class MyQueue<E> {
    //Node class for single linked list queue
    private static class Node<E> {
        //Instance variables for Node
        private E data;
        private Node next;

        //Constructor for Node, to be completed by you
        private Node(E dataItem) {  }

        //Constructor for Node, to be completed by you
        private Node(E dataItem, Node<E> nodeRef) {   }
    }

    //Instance variables for queue
    private Node<E> front;
    private Node<E> rear;
    private int size;

    //Constructor for queue, to be completed by you
    public MyQueue () {    }

    //Adds a node to queue, to be completed by you
    public boolean offer(E item) {    }

    //Returns the node at front of queue, to be completed by you
    public E peek() {    }

    //Returns and removes the node at front of queue, to be completed by you
    public E poll() {    }

    //Returns the data element at a specific index, to be completed by you
    public E get(int index) {    }

    //Returns the size of the queue, to be completed by you
    public int size() {		}
}
