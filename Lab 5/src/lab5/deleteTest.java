package lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class deleteTest {

    @Test
    void test() {
	MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
	// Test deleting from an empty list
	dll0.delete(1);
	assertEquals(0, dll0.getSize());

	// Test deleting from a non empty list
	dll0.insert(1);
	dll0.insert(2);
	dll0.insert(3);
	dll0.insert(4);

	// Test that elements have properly been added
	assertEquals(4, dll0.getSize());
	assertTrue(dll0.lookup(1));
	assertTrue(dll0.lookup(2));
	assertTrue(dll0.lookup(3));
	assertTrue(dll0.lookup(4));
	assertFalse(dll0.lookup(5));

	// Test removing last element
	dll0.delete(4);
	assertEquals(3, dll0.getSize());
	assertFalse(dll0.lookup(4));

	// Test removing intermediary element
	dll0.delete(2);
	assertEquals(2, dll0.getSize());
	assertFalse(dll0.lookup(2));

	// Test removing first element
	dll0.delete(1);
	assertEquals(1, dll0.getSize());
	assertFalse(dll0.lookup(1));

    }

}
