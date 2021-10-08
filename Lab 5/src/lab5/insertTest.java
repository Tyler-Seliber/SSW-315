package lab5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class insertTest {

    @Test
    void test() {
	// Test that a newly created doubly linked list is empty
	MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
	assertTrue(dll0.isEmpty());

	dll0.insert(1);
	dll0.insert(2);
	dll0.insert(3);

	// Test that modified linked list is not empty
	assertFalse(dll0.isEmpty());

	// Test that each element has been added to the list using lookup
	assertTrue(dll0.lookup(1));
	assertTrue(dll0.lookup(2));
	assertTrue(dll0.lookup(3));

	// Test that the list's size has correctly increased
	assertEquals(3, dll0.getSize());
    }

}
