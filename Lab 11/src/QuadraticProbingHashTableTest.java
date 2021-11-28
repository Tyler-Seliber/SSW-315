import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import org.junit.jupiter.api.Test;

class QuadraticProbingHashTableTest {

    private MyInteger n1, n2, n3, n4, n5, n6, n7, n8, n9;
    private MyString s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    private QuadraticProbingHashTable ht;
    private final int DICTIONARY_SIZE = 45402;

    private String dictionary_path, dictionary_rand_path, huck_finn_path;
    private String[] dictionary, dictionary_rand, huck_finn;

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

    @Test
    void testFiles() {
	// String variables for the three text files' path names
	dictionary_path = "linuxwords.txt";
	dictionary_rand_path = "linuxwords_rand.txt";
	huck_finn_path = "huckleberry_short.txt";

	// String arrays to hold the contents of each text file
	dictionary = fileReader(dictionary_path);
	dictionary_rand = fileReader(dictionary_rand_path);
	huck_finn = fileReader(huck_finn_path);

	// Hash tables to hash the contents of each text file
	QuadraticProbingHashTable dictionary_ht = new QuadraticProbingHashTable(DICTIONARY_SIZE * 2);
	QuadraticProbingHashTable dictionary_rand_ht = new QuadraticProbingHashTable(DICTIONARY_SIZE * 2);
	QuadraticProbingHashTable huck_finn_ht = new QuadraticProbingHashTable(DICTIONARY_SIZE * 2);

	// Insert the contents of each text file to their respective hash tables
	for (String s : dictionary) {
	    MyString ms = new MyString(s);
	    dictionary_ht.insert(ms);
	}

	for (String s : dictionary_rand) {
	    MyString ms = new MyString(s);
	    dictionary_rand_ht.insert(ms);
	}

	for (String s : huck_finn) {
	    MyString ms = new MyString(s);
	    huck_finn_ht.insert(ms);
	}

	// Check that each hash table has hashed all the words (duplicates NOT filtered)
	HashEntry[] ht_arr;
	int count;

	ht_arr = dictionary_ht.getTable();
	count = 0;
	for (HashEntry h : ht_arr) {
	    if (h == null)
		continue;
	    count++;
	}

	assertEquals(DICTIONARY_SIZE, count);

	ht_arr = dictionary_rand_ht.getTable();
	count = 0;
	for (HashEntry h : ht_arr) {
	    if (h == null)
		continue;
	    count++;
	}

	assertEquals(DICTIONARY_SIZE, count);

	ht_arr = huck_finn_ht.getTable();
	count = 0;
	for (HashEntry h : ht_arr) {
	    if (h == null)
		continue;
	    count++;
	}

//	assertEquals(DICTIONARY_SIZE, count);

	// Integer variables to store the number of probes from each hash table
	int dictionary_probes = dictionary_ht.getProbes();
	int dictionary_rand_probes = dictionary_rand_ht.getProbes();
	int huck_finn_probes = huck_finn_ht.getProbes();

//	// Print the hash table
//	ht_arr = huck_finn_ht.getTable();
//	for (int i = 0; i < ht_arr.length; i++) {
//	    HashEntry h = ht_arr[i];
//	    if (h == null) {
////		System.out.println("!NULL!");
//		continue;
//	    }
//	    System.out.print(i + ":\t");
//	    System.out.println(h.element);
//	}

    }

    // Method to read the contents of a txt file
    private String[] fileReader(String fileName) {
	String[] contents = new String[DICTIONARY_SIZE];
	try {
	    File myObj = new File(fileName);
	    Scanner myReader = new Scanner(myObj);
	    for (int i = 0; myReader.hasNextLine(); i++) {
		String data = myReader.nextLine();
		contents[i] = data;
	    }
	    myReader.close();
	} catch (FileNotFoundException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	return contents;
    }
}
