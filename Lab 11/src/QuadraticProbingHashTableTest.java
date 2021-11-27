import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class QuadraticProbingHashTableTest {

    private MyInteger n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private MyString s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    private QuadraticProbingHashTable ht;

    public QuadraticProbingHashTableTest() {
	n1 = new MyInteger(7);
	n2 = new MyInteger(22);
	n3 = new MyInteger(44);
	n4 = new MyInteger(43);
	n5 = new MyInteger(27);
	n6 = new MyInteger(89);
	n7 = new MyInteger(30);
	n8 = new MyInteger(64);
	n9 = new MyInteger(85);

	s1 = new MyString("A");
	s2 = new MyString("W");
	s3 = new MyString("X");
	s4 = new MyString("Y");
	s5 = new MyString("CM");
	s6 = new MyString("CK");
	s7 = new MyString("BD");
	s8 = new MyString("H");
	s9 = new MyString("MOB");
	s10 = new MyString("BD");
    }

    @Test
    void testGetTable() {
	ht = new QuadraticProbingHashTable(21);

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
	assertEquals(n1, ht_arr[7].element);
	assertEquals(n2, ht_arr[1].element);
	assertEquals(n3, ht_arr[2].element);
	assertEquals(n4, ht_arr[5].element);
	assertEquals(n5, ht_arr[6].element);
	assertEquals(n6, ht_arr[9].element);
	assertEquals(n7, ht_arr[10].element);
	assertEquals(n8, ht_arr[17].element);
	assertEquals(n9, ht_arr[16].element);

    }

    @Test
    void testGetProbes() {
	ht = new QuadraticProbingHashTable(21);

	ht.insert(n1);
	assertEquals(1, ht.getProbes());

	ht.insert(n2);
	assertEquals(2, ht.getProbes());

	ht.insert(n3);
	assertEquals(3, ht.getProbes());

	ht.insert(n4);
	assertEquals(6, ht.getProbes());

	ht.insert(n5);
	assertEquals(7, ht.getProbes());

	ht.insert(n6);
	assertEquals(10, ht.getProbes());

	ht.insert(n7);
	assertEquals(12, ht.getProbes());

	ht.insert(n8);
	assertEquals(17, ht.getProbes());

	ht.insert(n9);
	assertEquals(24, ht.getProbes());

    }

    @Test
    void testStrings() {
	ht = new QuadraticProbingHashTable(23);

	ht.insert(s1);
	assertEquals(1, ht.getProbes());

	ht.insert(s2);
	assertEquals(2, ht.getProbes());

	ht.insert(s3);
	assertEquals(4, ht.getProbes());

	ht.insert(s4);
	assertEquals(6, ht.getProbes());

	ht.insert(s5);
	assertEquals(7, ht.getProbes());

	ht.insert(s6);
	assertEquals(8, ht.getProbes());

	ht.insert(s7);
	assertEquals(10, ht.getProbes());

	ht.insert(s8);
	assertEquals(13, ht.getProbes());

	ht.insert(s9);
	assertEquals(17, ht.getProbes());

	ht.insert(s10);
	assertEquals(17, ht.getProbes());

    }

}
