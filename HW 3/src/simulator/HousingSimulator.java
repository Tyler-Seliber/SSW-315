package simulator;

import java.util.Scanner;

public class HousingSimulator {
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
	MyQueue<Apartment> apartmentQueue = new MyQueue<Apartment>();
	int studentQualMin = 0, studentQualMax = 1;
	int apartmentQualMin = 0, apartmentQualMax = 1;
	int apartmentYearMin = 1, apartmentYearMax = 3;

	for (int i = 0; i < k; i++) {
	    double studentQuality = randomDouble(studentQualMin, studentQualMax);
	    studentQueue.offer(new Student(studentQuality, i));
	}

	for (int i = 0; i < N; i++) {
	    double apartmentQuality = randomDouble(apartmentQualMin, apartmentQualMax);
	    // int apartmentYearsLeft = randomInt(apartmentYearMin, apartmentYearMax);
	    apartmentQueue.offer(new Apartment(apartmentQuality, i, 0));
	}

	// 3 year simulation
	for (int currentYear = 1; currentYear <= 3; currentYear++) {

	    // While studentQueue has a first value
	    while (studentQueue.peek() != null) {
		Student stu = studentQueue.peek();
		Apartment apt = apartmentQueue.peek();
		if (stu.getQualityThreshold() > apt.getQuality()) {
		    // TODO
		}
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

	runSimulation(k, N);
    }
}
