/* OpenCommercial.java */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A class that provides a main function to read five lines of a commercial Web
 * page and print them in reverse order, given the name of a company.
 */

class OpenCommercial {

    /**
     * Prompts the user for the name X of a company (a single string), opens the Web
     * site corresponding to www.X.com, and prints the first five lines of the Web
     * page in reverse order.
     * 
     * @param arg is not used.
     * @exception Exception thrown if there are any problems parsing the user's
     *                      input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

	BufferedReader keyboard;
	String inputLine;

	keyboard = new BufferedReader(new InputStreamReader(System.in));

	System.out.print("Please enter the name of a company (without spaces): ");
	System.out.flush(); /* Make sure the line is printed immediately. */
	inputLine = keyboard.readLine();

	// The following code is adapted from SSW-315 lecture notes:
	// L02aObjectsClasses.pdf slide 17

	URL u = new URL("https://www." + inputLine + ".com");
	InputStream ins = u.openStream();
	InputStreamReader isr = new InputStreamReader(ins);
	BufferedReader site = new BufferedReader(isr);

	// Read the first five lines of the web page
	String[] lines = new String[5];
	for (int i = 0; i < lines.length; i++) {
	    lines[i] = site.readLine();
	}

	// Print the first five lines in reverse order
	for (int i = lines.length - 1; i > -1; i--) {
	    System.out.println(lines[i]);
	}

    }
}
