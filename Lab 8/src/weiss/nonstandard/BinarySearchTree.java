package weiss.nonstandard;

// BinarySearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// void removeMin( )      --> Remove minimum item
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Exceptions are thrown by insert, remove, and removeMin if warranted

/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo method.
 * 
 * @author Mark Allen Weiss
 * @author Tyler Seliber
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    /**
     * Construct the tree.
     */
    public BinarySearchTree() {
	root = null;
    }

    /**
     * Insert into the tree.
     * 
     * @param x the item to insert.
     * @throws DuplicateItemException if x is already present.
     */
    public void insert(AnyType x) {
	root = insert(x, root);
    }

    /**
     * Remove from the tree..
     * 
     * @param x the item to remove.
     * @throws ItemNotFoundException if x is not found.
     */
    public void remove(AnyType x) {
	root = remove(x, root);
    }

    /**
     * Remove minimum item from the tree.
     * 
     * @throws ItemNotFoundException if tree is empty.
     */
    public void removeMin() {
	root = removeMin(root);
    }

    /**
     * Find the smallest item in the tree.
     * 
     * @return smallest item or null if empty.
     */
    public AnyType findMin() {
	return elementAt(findMin(root));
    }

    /**
     * Find the largest item in the tree.
     * 
     * @return the largest item or null if empty.
     */
    public AnyType findMax() {
	return elementAt(findMax(root));
    }

    /**
     * Find an item in the tree.
     * 
     * @param x the item to search for.
     * @return the matching item or null if not found.
     */
    public AnyType find(AnyType x) {
	return elementAt(find(x, root));
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
	root = null;
    }

    /**
     * Test if the tree is logically empty.
     * 
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
	return root == null;
    }

    /**
     * Internal method to get element field.
     * 
     * @param t the node.
     * @return the element field or null if t is null.
     */
    private AnyType elementAt(BinaryNode<AnyType> t) {
	return t == null ? null : t.element;
    }

    /**
     * Internal method to insert into a subtree.
     * 
     * @param x the item to insert.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws DuplicateItemException if x is already present.
     */
    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
	if (t == null)
	    t = new BinaryNode<AnyType>(x);
	else if (x.compareTo(t.element) < 0)
	    t.left = insert(x, t.left);
	else if (x.compareTo(t.element) > 0)
	    t.right = insert(x, t.right);
	else
	    throw new DuplicateItemException(x.toString()); // Duplicate
	return t;
    }

    /**
     * Internal method to remove from a subtree.
     * 
     * @param x the item to remove.
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if x is not found.
     */
    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
	if (t == null)
	    throw new ItemNotFoundException(x.toString());
	if (x.compareTo(t.element) < 0)
	    t.left = remove(x, t.left);
	else if (x.compareTo(t.element) > 0)
	    t.right = remove(x, t.right);
	else if (t.left != null && t.right != null) // Two children
	{
	    t.element = findMin(t.right).element;
	    t.right = removeMin(t.right);
	} else
	    t = (t.left != null) ? t.left : t.right;
	return t;
    }

    /**
     * Internal method to remove minimum item from a subtree.
     * 
     * @param t the node that roots the tree.
     * @return the new root.
     * @throws ItemNotFoundException if t is empty.
     */
    protected BinaryNode<AnyType> removeMin(BinaryNode<AnyType> t) {
	if (t == null)
	    throw new ItemNotFoundException();
	else if (t.left != null) {
	    t.left = removeMin(t.left);
	    return t;
	} else
	    return t.right;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * 
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    protected BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
	if (t != null)
	    while (t.left != null)
		t = t.left;

	return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     * 
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
	if (t != null)
	    while (t.right != null)
		t = t.right;

	return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * 
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<AnyType> find(AnyType x, BinaryNode<AnyType> t) {
	while (t != null) {
	    if (x.compareTo(t.element) < 0)
		t = t.left;
	    else if (x.compareTo(t.element) > 0)
		t = t.right;
	    else
		return t; // Match
	}

	return null; // Not found
    }

    /**
     * See if the tree contains a given item.
     * 
     * @param target the item to search for
     * @return true if the item is in the tree
     */
    public boolean contains(AnyType target) {
	return search(root, target);
    }

    /** Recursively search the tree for the target */
    private boolean search(BinaryNode<AnyType> curr, AnyType target) {
	if (curr == null)
	    return false;
	if (curr.element.compareTo(target) < 0)
	    return search(curr.right, target);
	if (curr.element.compareTo(target) > 0)
	    return search(curr.left, target);
	if (curr.element.compareTo(target) == 0)
	    return true;
	return false;
    }

    /**
     * Show an ordered list of the items in the tree, one item per line.
     */
    public void list() {
	traverseInOrder(root);
    }

    /** Recursive in-order traversal of the tree, printing each node */
    private void traverseInOrder(BinaryNode<AnyType> curr) {
	if (curr == null)
	    return;
	if (curr.left != null && curr.element.compareTo(curr.left.element) > 0) {
	    traverseInOrder(curr.left);
	}
	System.out.println(curr.element + " ");
	if (curr.right != null && curr.element.compareTo(curr.right.element) < 0) {
	    traverseInOrder(curr.right);
	}
    }

    // Extra credit

    /** Print a formatted display of the tree. */
    public void print() {
	traversePreOrder(root, 0);
    }

    /**
     * Recursive pre-order traversal of the tree, printing each node indented an
     * amount corresponding to its level in the tree.
     */
    private void traversePreOrder(BinaryNode<AnyType> curr, int indent) {
	// TODO: Implement this method
	if (curr == null)
	    return;
	for (int i = 0; i < indent; i++)
	    System.out.print("   ");

	System.out.println(curr.element + " ");
	if (curr.left != null && curr.element.compareTo(curr.left.element) > 0) {
	    traversePreOrder(curr.left, indent + 1);
	} else if (curr.left == null) {
	    for (int i = 0; i < indent + 1; i++)
		System.out.print("   ");
	    System.out.println(".");
	}

	if (curr.right != null && curr.element.compareTo(curr.right.element) < 0) {
	    traversePreOrder(curr.right, indent + 1);
	} else if (curr.right == null) {
	    for (int i = 0; i < indent + 1; i++)
		System.out.print("   ");
	    System.out.println(".");
	}
    }

    /** The tree root. */
    protected BinaryNode<AnyType> root;

    // Test program
    public static void main(String[] args) {
	BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
	final int NUMS = 4000;
	final int GAP = 37;

	System.out.println("Checking... (no more output means success)");

	for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
	    t.insert(i);

	for (int i = 1; i < NUMS; i += 2)
	    t.remove(i);

	if (t.findMin() != 2 || t.findMax() != NUMS - 2)
	    System.out.println("FindMin or FindMax error!");

	for (int i = 2; i < NUMS; i += 2)
	    if (t.find(i) != i)
		System.out.println("Find error1!");

	for (int i = 1; i < NUMS; i += 2)
	    if (t.find(i) != null)
		System.out.println("Find error2!");

	BinarySearchTree<String> bst = new BinarySearchTree<String>();
//	bst.insert(50);
//	bst.insert(20);
//	bst.insert(75);
//	bst.insert(98);
//	bst.insert(80);
//	bst.insert(31);
//	bst.insert(150);
//	bst.insert(39);
//	bst.insert(23);
//	bst.insert(11);
//	bst.insert(77);
//	bst.list();
//	System.out.println(bst.contains(50));
//	System.out.println(bst.contains(12));
//	System.out.println(bst.contains(150));

	bst.insert("E");
	bst.insert("D");
	bst.insert("N");
	bst.insert("K");
	bst.insert("F");
	bst.insert("H");
	bst.insert("L");
	bst.insert("S");
	bst.insert("W");
	bst.print();

    }
}
