package com.program;

public class Prime {

	public static boolean isPrime(int p) {

		if (p == 2) return true;

		if (p % 2 == 0) {
			return false;
		}

		for (int i=3; i*i <= p; i+=2) {
			if (p % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 31;

		System.out.println(num + " is Prime ? " +  Prime.isPrime(num));
	}

}
