package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class newDLLTest {

    @Test
    void test() {
	// Test that a newly created doubly linked list is empty
	MyDLLImpl<Integer> dll0 = new MyDLLImpl<Integer>();
	assertTrue(dll0.isEmpty());
    }

}
