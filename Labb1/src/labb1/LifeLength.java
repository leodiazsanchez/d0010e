package labb1;

public class LifeLength {
	
	
	//Collatz conjecture
	public static int f1(int a0) {
		if(a0==1){
				return 1;
		}	else if(a0 % 2 == 0) {
				return a0/2;
		}	else {
				return 3*a0+1;
		}
	}
	
	public static int f2(int a0) {
		return f1(f1(a0));
	}
	
	public static int f4(int a0) {
		return f2(f2(a0));
	}
	
	public static int f8 (int a0) {
		return f4(f4(a0));
	}
	
	public static int f16 (int a0) {
		return f8(f8(a0));
	}
	
	public static int f32 (int a0) {
		return f16(f16(a0));
	}
	

	public static int iterateF(int a0, int n) {
		for (int i = 0; i <= n-1; i++) {
			 	a0 = f1(a0);
			}
		return a0;
	}
	
	public static int iterLifeLength(int a0) {
		int life = 0;
		while (a0!=1){
			a0 = f1(a0);
			life++;
		}
		
		return life;
	}
	
	public static int recLifeLength(int a0) {
		if (a0==1) {
			return 0;
		} else  {
			return 1 + recLifeLength(f1(a0));
		}
	}
	
	public static String intsToString(int x){
		return "The life length of " + x + " is " + iterLifeLength(x)  + ".";
	}
	
	
	public static void task1(int first, int second,int third ) {
		/* Task 1*/
		
		System.out.println("Task 1:");
		System.out.println("");
		System.out.println(f1(first));
		System.out.println(f1(second));
		System.out.println(f1(third));
	}
	
	public static void task2() {
		/* Task 2*/
		System.out.println("Task 2:");
		System.out.print("f1=" + f1(42) + "\t");
		System.out.print("f2=" + f2(42) + "\t");
		System.out.print("f4=" +f4(42) + "\t");
		System.out.print("f8=" +f8(42) + "\t");
		System.out.print("f16=" +f16(42) + "\t");
		System.out.print("f32=" +f32(42) + "\t");
	}
	
	public static void task3() {
		/* Task 3*/
		
		System.out.println("Task 3:");
		System.out.println(iterateF(3,5));
		System.out.println(iterateF(42,3));
		System.out.println(iterateF(1,3));
	}
	
	public static void task4() {
		/* Task 4*/
		System.out.println("Task 4:");
		for (int i = 1; i <= 15; i++) {
			System.out.println(intsToString(i));
		}
	}
	
	public static void task6() {
		/* Task 6*/
		System.out.println("Task 6:");
		for (int i = 1; i <= 15; i++) {
			System.out.println(iterLifeLength(i) + " " + recLifeLength(i));
			
		}
	}

	public static void main(String[] args) {
		int first = Integer.parseInt(args[0]);
		int second = Integer.parseInt(args[1]);
		int third = Integer.parseInt(args[2]);
		int n = 6;
		switch (n){
			case 1:	
				task1(first,second,third);
				break;
			case 2:
				task2();
				break;
			case 3:
				task3();
				break;
			case 4:
				task4();
				break;
			case 6:
				task6();
				break;
			default:
				System.out.println("Please input a number n: {1,2,3,4,6}");
		}			
	}
}
