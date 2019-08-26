package com.design.cache;

public class Test {

	public static void main(String[] args) {

		System.out.println(b(new int[]{-5,4,-2,3,1,-1,-6,-1,0,5}));

	}

	public static int b(int c[]) {
		int a = 0;
		int d= 0;
		for (int i = 0; i < c.length; i++) {
			if(c[i] < 0) {
				a += c[i];
			} else{
				a = 0;
			}
			d = Math.min(a, d);
		}

		return Math.abs(d);
	}

}
