import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	pq.add(7);
	pq.add(8);
	pq.add(1);
	pq.add(6);
	pq.add(2);
	pq.add(3);
	pq.add(5);
	pq.add(4);
	System.out.println("After Using add method.");
	for (int s : pq) {
	    System.out.println(s);
	}
	System.out.println("After Using poll method.");
	pq.poll();
	for (int s : pq) {
	    System.out.println(s);
	}
	System.out.println("After Using remove method.");
	pq.remove(3);
	for (int s : pq) {
	    System.out.println(s);
	}
    }
}