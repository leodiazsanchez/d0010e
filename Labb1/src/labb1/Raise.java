package labb1;

public class Raise {

	// Task 9

	public static double recRaiseOne(double x, int k) {
		if (k == 0) {
			return 1.0;
		} else {
			return x * recRaiseOne(x, k - 1);
		}
	}

	// Task 8

	public static double recRaiseHalf(double x, int k) {
		if (k == 0) {
			return 1;
		} else if (k % 2 == 0) {
			double var = recRaiseHalf(x, (int) (Math.floor(k / 2)));
			return var * var;
		} else {
			double var = recRaiseHalf(x, (int) (Math.floor(k / 2)));
			return x * var * var;
		}
	}

	// Task 9

	public static double callsOne(int k) {
		if (k == 0) {
			return 0;
		} else {
			return 1 + callsOne(k - 1);
		}
	}

	public static double callsHalf(int k) {
		if (k == 0) {
			return 0;
		} else {
			return 1 + callsHalf((int) (Math.floor(k / 2)));
		}
	}
	
	// Task 9
	public static void task9() {
		double x = 1.5;
		double y = 15;
		System.out.println("Task 9");
		System.out.printf("%-22s%-22s%-22s%-22s\n", "ResultHalf", "ResultOne", "CallsHalf", "CallsOne");
		for (int i = 1; i <= y; i++) {
			System.out.printf("%-22s%-22s%-22s%-22s\n", recRaiseHalf(x,i), recRaiseOne(x,i), callsHalf(i),callsOne(i));
		}
	}

	// Problem 10
	public static void task10() {
		double x = 1.0001;
		double y = 10000;
		System.out.println("Problem 10");
		System.out.printf("%-22s%-22s%-22s%-22s\n", "ResultHalf", "ResultOne", "CallsHalf", "CallsOne");
		for (int i = 1; i <= y; i++) {
			System.out.printf("%-22s%-22s%-22s%-22s\n", recRaiseHalf(x,i), recRaiseOne(x,i), callsHalf(i),callsOne(i));
		}
	}
	

	public static void main(String[] args) {
		task9();
		//task10();
	}

}
