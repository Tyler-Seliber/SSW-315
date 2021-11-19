import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QuadraticProbingHashTableTest {

    @Test
    void testGetTable() {
	QuadraticProbingHashTable ht = new QuadraticProbingHashTable(21);

	MyInteger n1, n2, n3, n4, n5, n6, n7, n8, n9;

	n1 = new MyInteger(7);
	n2 = new MyInteger(22);
	n3 = new MyInteger(44);
	n4 = new MyInteger(43);
	n5 = new MyInteger(27);
	n6 = new MyInteger(89);
	n7 = new MyInteger(30);
	n8 = new MyInteger(64);
	n9 = new MyInteger(85);

	ht.insert(n1);
	ht.insert(n2);
	ht.insert(n3);
	ht.insert(n4);
	ht.insert(n5);
	ht.insert(n6);
	ht.insert(n7);
	ht.insert(n8);
	ht.insert(n9);

	HashEntry[] ht_arr = ht.getTable();
	assertTrue(ht_arr[7].element.equals(n1));
	assertTrue(ht_arr[1].element.equals(n2));
	assertTrue(ht_arr[2].element.equals(n3));
	assertTrue(ht_arr[5].element.equals(n4));
	assertTrue(ht_arr[6].element.equals(n5));
	assertTrue(ht_arr[9].element.equals(n6));
	assertTrue(ht_arr[10].element.equals(n7));
	assertTrue(ht_arr[17].element.equals(n8));
	assertTrue(ht_arr[16].element.equals(n9));

    }

}
