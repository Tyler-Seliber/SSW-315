import java.util.LinkedList;

public class BinarySearchTree<Object extends Comparable<Object>> {

    // An inner class for the nodes in the tree
    private class Node {
	private LinkedList<Object> data; // list of data values for this node
	private Node left; // reference to left child/subtree
	private Node right; // reference to right child/subtree

	private Node(Object data) {
	    this.data = new LinkedList<Object>();
	    this.data.add(data);
	    this.left = null;
	    this.right = null;
	}
    }

    private Node root; // the root of the binary search tree

    public BinarySearchTree() {
	root = null;
    }

    /*
     * Insert a new node to the binary search tree.
     */
    public void insert(Object data) {
	// Find the parent of the new node
	Node parent = null;
	Node curr = root;
	while (curr != null) {
	    // If curr has data and the data in curr is equal to the data to be added
	    if (curr.data.getFirst() != null && curr.data.getFirst().compareTo(data) == 0) {
		// Add data to curr's linked list of data
		curr.data.add(data);
		return;
	    }
	    parent = curr;
	    if (curr.data.getFirst() != null && data.compareTo(curr.data.getFirst()) < 0)
		curr = curr.left;
	    else
		curr = curr.right;
	}

	// Insert the new node
	Node newNode = new Node(data);
	if (parent == null) // the tree was empty
	    root = newNode;
	else if (parent.data.getFirst() != null && data.compareTo(parent.data.getFirst()) < 0)
	    parent.left = newNode;
	else
	    parent.right = newNode;
    }

    /*
     * Deletes the node containing data and return the associated data item
     */
    public LinkedList delete(Object data) {
	// Find the node to be deleted and its parent
	Node parent = null;
	Node curr = root;
	while (curr != null && curr.data.getFirst() != null && curr.data.getFirst().compareTo(data) != 0) {
	    parent = curr;
	    if (data.compareTo(curr.data.getFirst()) < 0)
		curr = curr.left;
	    else
		curr = curr.right;
	}

	// Delete the node (if any) and return the removed data item
	if (curr == null) // No node with data
	    return null;
	else if (curr.data.size() > 1) { // If there is duplicate data in the node, remove one instance of that data
	    LinkedList removedData = new LinkedList<>();
	    removedData.add(curr.data.pop());
	    return removedData;
	} else {
	    LinkedList removedData = curr.data;
	    deleteNode(curr, parent);
	    return removedData;
	}
    }

    /*
     * Deletes the node specified by the parameter toDelete. parent specifies the
     * parent of the node to be deleted.
     */
    private void deleteNode(Node toDelete, Node parent) {
	if (toDelete.left != null && toDelete.right != null) {
	    // Case 3: toDelete has two children.
	    // Find a replacement for the item we're deleting -- as well as
	    // the replacement's parent.
	    // We use the smallest item in toDelete's right subtree as
	    // the replacement.
	    Node replaceParent = toDelete;
	    Node replace = toDelete.right;
	    while (replace.left != null) {
		replaceParent = replace;
		replace = replace.left;
	    }

	    // Replace toDelete's key and data with those of the
	    // replacement item.
	    toDelete.data = replace.data;

	    // Recursively delete the replacement item's old node.
	    // It has at most one child, so we don't have to
	    // worry about infinite recursion.
	    deleteNode(replace, replaceParent);
	} else {
	    // Cases 1 and 2: toDelete has 0 or 1 child
	    Node toDeleteChild;
	    if (toDelete.left != null) {
		toDeleteChild = toDelete.left;
	    } else {
		toDeleteChild = toDelete.right; // null if it has no children
	    }

	    if (toDelete == root) {
		root = toDeleteChild;
	    } else if (toDelete.data.getFirst().compareTo(parent.data.getFirst()) < 0) {
		parent.left = toDeleteChild;
	    } else {
		parent.right = toDeleteChild;
	    }
	}
    }

    /*
     * Prints the keys of the tree in the order given by a preorder traversal.
     * Invokes the recursive preorderPrintTree method to do the work.
     */
    public String toString() {
	String str = "";
	if (root != null) {
	    str += preorderPrintTree(root);
	}
	return str;
    }

    /*
     * Recursively performs a preorder traversal of the tree/subtree whose root is
     * specified, printing the keys of the visited nodes. Note that the parameter is
     * *not* necessarily the root of the entire tree.
     */
    private String preorderPrintTree(Node root) {
	String s = root.data + " ";
	if (root.left != null) {
	    s += preorderPrintTree(root.left);
	}
	if (root.right != null) {
	    s += preorderPrintTree(root.right);
	}
	return s;
    }

    public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	tree.insert('G');
	tree.insert('I');
	tree.insert('E');
	tree.insert('H');
	tree.insert('F');
	tree.insert('E');
	tree.insert('A');
	tree.insert('M');
	tree.insert('J');
	tree.insert('N');
	tree.insert('M');
	tree.insert('E');
	System.out.println(tree);

	System.out.println(tree.delete('E'));
	System.out.println(tree);
	System.out.println(tree.delete('G'));
	System.out.println(tree);
	System.out.println(tree.delete('E'));
	System.out.println(tree);
	System.out.println(tree.delete('E'));
	System.out.println(tree);
	System.out.println(tree.delete('E'));
	System.out.println(tree);

    }

}
