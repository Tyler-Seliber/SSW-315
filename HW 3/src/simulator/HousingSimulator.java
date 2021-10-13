package simulator;

import java.util.ArrayList;
import java.util.Scanner;

public class HousingSimulator {
    //Functions for generating random double
    public static double randomDouble(int from, int to) {
        return Math.random() * to + from;
    }

    //Functions for generating random int
    public static int randomInt(int from, int to) {
        return (int) Math.random() * to + from;
    }

	//To be completed by you
    public static void runSimulation(int k, int N) { }

    //Main method for simulation
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students to run simulation with: ");
        int k = sc.nextInt();

        System.out.print("Enter number of apartments to run simulation with: ");
        int N = sc.nextInt();

        runSimulation(k, N);
    }
}
