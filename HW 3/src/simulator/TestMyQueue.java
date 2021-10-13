package simulator;

public class TestMyQueue {
    public static void main(String[] args) {
	MyQueue<Integer> q = new MyQueue<Integer>();

	System.out.print("New queue size (should be 0) = ");
	System.out.println(q.size());

	System.out.println();

	q.offer(0);
	System.out.print("First element of queue (should be 0) = ");
	System.out.println(q.peek());
	System.out.print("New queue size (should be 1) = ");
	System.out.println(q.size());

	System.out.println();

	q.offer(1);
	System.out.print("First element of queue (should be 0) = ");
	System.out.println(q.peek());
	System.out.print("Item at index 1 (should be 1) = ");
	System.out.println(q.get(1));
	System.out.print("New queue size (should be 2) = ");
	System.out.println(q.size());

	System.out.println();

	q.offer(2);
	q.offer(3);
	System.out.print("New queue size (should be 4) = ");
	System.out.println(q.size());
	System.out.print("Item at index 0 (should be 0) = ");
	System.out.println(q.get(0));
	System.out.print("Item at index 1 (should be 1) = ");
	System.out.println(q.get(1));
	System.out.print("Item at index 2 (should be 2) = ");
	System.out.println(q.get(2));
	System.out.print("Item at index 3 (should be 3) = ");
	System.out.println(q.get(3));
	System.out.print("Item at index 5 (should be null) = ");
	System.out.println(q.get(5));
	System.out.print("Item at index -1 (should be null) = ");
	System.out.println(q.get(-1));

	System.out.println();

	System.out.print("Output should be 0 = ");
	System.out.println(q.poll());
	System.out.print("New queue size (should be 3) = ");
	System.out.println(q.size());
	System.out.print("Item at index 2 (should be 3) = ");
	System.out.println(q.get(2));
	System.out.print("Item at index 3 (should be null) = ");
	System.out.println(q.get(3));

	System.out.println();

	q.poll();
	q.poll();
	q.poll();
	System.out.print("New queue size (should be 0) = ");
	System.out.println(q.size());
	System.out.print("First element (should be null) = ");
	System.out.println(q.peek());
	System.out.print("Item at index 0 (should be null) = ");
	System.out.println(q.get(0));
	System.out.print("Output should be null = ");
	System.out.println(q.poll());
	System.out.print("New queue size (should be 0) = ");
	System.out.print(q.size());
    }
}
