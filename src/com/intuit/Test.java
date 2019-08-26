package com.intuit;

import java.util.Scanner;

public class Test {

	/*
	 * public static void main(String[] args) throws InterruptedException { int
	 * i = -7; while (i < 3) { A a = new A("ABC"); B b = new B(a.getInput()); C
	 * c = new C(b.getInput());
	 * 
	 * Thread t1 = new Thread(a); Thread t2 = new Thread(b); Thread t3 = new
	 * Thread(c); t1.start(); t1.join();
	 * 
	 * t2.start(); t2.join();
	 * 
	 * t3.start(); t3.join(); System.out.println("***********"); } }
	 */

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);		
		long n = sc.nextLong();
		int k = sc.nextInt();
		long q = sc.nextInt();

		String[] temp = new String[(int)n];
		for (int i = 0; i < n; i++) {
			temp[i] = sc.next();
		}
		print(n, k, q, temp);
		//print(4, 4, 100, new String[]{"K","D","P","M"});
	}

	public static void print(long n, int k, long q, String[] temp) {
		long x = ((q - 1) * k) % n;
		for (int i = 0; i < k; i++) {
			int val = (int) ((i + x) % n);
			System.out.println(temp[val]);
		}
	}

}

class A implements Runnable {

	String input;

	A(String input) {
		this.input = input;
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	public void execute() {
		System.out.println("reverse");
	}

	@Override
	public void run() {
		execute();

	}
}

class B implements Runnable {

	String input;

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	B(String input) {
		this.input = input;
	}

	@Override
	public void run() {
		execute();

	}

	public void execute() {
		System.out.println("BASE 64");
	}
}

class C implements Runnable {

	String input;

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	C(String input) {
		this.input = input;
	}

	@Override
	public void run() {
		execute();

	}

	public void execute() {
		System.out.println("print");
	}
}