import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) throws FileNotFoundException {
	// Scanner in = new Scanner(new File("test.in"));
	// // do something ...
	try {
	    Scanner in = new Scanner(new File("test.in"));
	    // do something if no exception
	    // you main logic here in the try-block
	} catch (FileNotFoundException ex) { // error handling separated from the main logic
	    ex.printStackTrace(); // print the stack trace
	}

    }
}
