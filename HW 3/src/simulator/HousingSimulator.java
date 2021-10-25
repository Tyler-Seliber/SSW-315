package simulator;

import java.util.Scanner;

public class HousingSimulator {

    /*
     * Store a value that compares to the number of apartments k to determine if it
     * is a small amount. If so, the steps of each process from the program will be
     * output.
     * 
     * Given the context that this is a university offering housing for students,
     * there is no definitive value for "small." This value can be adjusted as
     * necessary.
     */
    private static final int SMALL_THRESHOLD = 10;
    private static int TOTAL_APARTMENTS = 0;

    /*
     * Method to output the steps of each process if k is small.
     * 
     * @param s the step to be printed to the console
     */
    public static void stepOutput(String s) {
	if (TOTAL_APARTMENTS <= SMALL_THRESHOLD)
	    System.out.println(s);
    }

    // Functions for generating random double
    public static double randomDouble(int from, int to) {
	return Math.random() * to + from;
    }

    // Functions for generating random int
    public static int randomInt(int from, int to) {
	return (int) Math.floor(Math.random() * (to - from + 1) + from);
    }

    // To be completed by you
    public static void runSimulation(int k, int N) {
	// Create and fill the student and apartment queues
	MyQueue<Student> studentQueue = new MyQueue<Student>();
	MyQueue<Student> studentViewed = new MyQueue<Student>();
	MyQueue<Apartment> apartmentQueue = new MyQueue<Apartment>();
	MyQueue<Apartment> occupiedApartments = new MyQueue<Apartment>();
	MyQueue<Apartment> shownApartments = new MyQueue<Apartment>();
	MyQueue<Apartment> stillOccupiedApartments = new MyQueue<Apartment>();
	int studentQualMin = 0, studentQualMax = 1;
	int apartmentQualMin = 0, apartmentQualMax = 1;
	int apartmentYearMin = 1, apartmentYearMax = 3;
	TOTAL_APARTMENTS = N;

	// Fill student queue with students
	for (int i = 0; i < k; i++) {
	    double studentQuality = randomDouble(studentQualMin, studentQualMax);
	    studentQueue.offer(new Student(studentQuality, i));
	}

	// Fill apartment queue with apartments
	for (int i = 0; i < N; i++) {
	    double apartmentQuality = randomDouble(apartmentQualMin, apartmentQualMax);
	    // int apartmentYearsLeft = randomInt(apartmentYearMin, apartmentYearMax);
	    apartmentQueue.offer(new Apartment(apartmentQuality, i, 0));
	}

	// 3 year simulation
	for (int currentYear = 1; currentYear <= 3; currentYear++) {

	    stepOutput("--- Starting year " + currentYear + " ---");

	    // Keep track of newly occupied and vacated apartments
	    int newlyOccupied = 0, vacated = 0;

	    // Put shown apartments back in apartmentQueue
	    while (shownApartments.size() > 0)
		apartmentQueue.offer(shownApartments.poll());

	    // Add available apartments to apartmentQueue, otherwise decrease the years they
	    // have left for occupation and keep them as occupied

	    while (occupiedApartments.size() > 0) {
		Apartment currApt = occupiedApartments.peek();
		currApt.setYearsLeft(currApt.getYearsLeft() - 1);
		if (currApt.getYearsLeft() == 0) {
		    apartmentQueue.offer(occupiedApartments.poll());
		    vacated++;
		    stepOutput("Apartment " + apartmentQueue.getRear().getIDNum()
			    + " has been vacated and added back to the queue of available apartments.");
		}

		else
		    stillOccupiedApartments.offer(occupiedApartments.poll());
	    }

	    // Put still occupied apartments back into occupiedApartments
	    while (stillOccupiedApartments.size() > 0)
		occupiedApartments.offer(stillOccupiedApartments.poll());

	    // While students and apartments are available
	    while (studentQueue.size() > 0 && apartmentQueue.size() > 0) {
		Student stu = studentQueue.peek();
		Apartment apt = apartmentQueue.peek();

		// Check that apt isn't null
		if (apt != null) {

		    // Check if student rejects apartment
		    if (stu.getQualityThreshold() > apt.getQuality()) {
			studentViewed.offer(studentQueue.poll());
			stepOutput("Student " + stu.getIDNum() + " has rejected apartment " + apt.getIDNum() + ".");
		    }

		    // If a student accepts an apartment, remove it from the queue of available
		    // apartments
		    else {
			apt.setYearsLeft(randomInt(apartmentYearMin, apartmentYearMax));
			occupiedApartments.offer(apartmentQueue.poll());
			studentQueue.poll();
			newlyOccupied++;
			stepOutput("Student " + stu.getIDNum() + " has accepted apartment " + apt.getIDNum() + " for "
				+ apt.getYearsLeft() + " year(s).");

			// After the last student accepts an apartment (student queue empty), treat the
			// un-shown apartments as shown to make number of unoccupied apartments
			// consistent

			while (studentQueue.size() == 0 && apartmentQueue.size() > 0)
			    shownApartments.offer(apartmentQueue.poll());
		    }

		    // Check if all students have seen this apartment this year. If so, remove that
		    // apartment from the queue of available apartments for this year.
		    if (studentQueue.size() == 0) {

			shownApartments.offer(apartmentQueue.poll());
			stepOutput("All students have seen and rejected apartment " + apt.getIDNum() + ".");

			while (studentViewed.size() > 0)
			    studentQueue.offer(studentViewed.poll());

		    }
		}

		// If the students have seen and rejected all the apartments, increment the
		// years they are on the list and increase their desperation.
		if (apartmentQueue.size() == 0) {

		    if (occupiedApartments.size() == N)
			stepOutput("All apartments have been occupied for this year.");

		    else {
			while (studentQueue.size() > 0) {
			    stu = studentQueue.peek();
			    if (stu.getYearsOnList() < currentYear)
				break;
			    stu.addDesperation();
			    stu.addYear();
			    studentQueue.offer(stu);
			}

			while (studentViewed.size() > 0) {
			    stu = studentViewed.poll();
			    stu.addDesperation();
			    stu.addYear();
			    studentQueue.offer(stu);
			}
			stepOutput("All students have seen and rejected all apartments for this year.");
		    }
		}
	    }

	    // Print stats for the year
	    System.out.println("--- Stats for year " + currentYear + " ---");
	    System.out.println("Students without apartments = " + studentQueue.size());
	    System.out.println("Number of total occupied apartments = " + occupiedApartments.size());
	    System.out.println("Number of unoccupied apartments = " + shownApartments.size());
	    System.out.println("Number of newly occupied apartments = " + newlyOccupied);
	    System.out.println("Number of vacated apartments = " + vacated);
	    System.out.println();

	    // If all students have accepted an apartment, end the simulation.
	    if (studentQueue.size() == 0) {
		System.out.println("All students have occupied an apartment. No more students are left in the queue.");
		return;
	    }
	}
    }

    // Main method for simulation
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	System.out.print("Enter number of students to run simulation with: ");
	int k = sc.nextInt();

	System.out.print("Enter number of apartments to run simulation with: ");
	int N = sc.nextInt();

	System.out.println();

	runSimulation(k, N);

	System.out.println("The simulation has ended.");
    }
}
