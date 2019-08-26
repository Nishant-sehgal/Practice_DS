package com.program;

public class Test {

	static int a(int j){
		 int i = 50;
		 int k ;
		 if(i==j){
			 System.out.println("dsvf");
			 k=a(i);
			 return 0;
		 }else{
			 return 0;
		 }

	}
	public static void main(String[] args) {
	/*for (int i = 1; i < 10; i=i*2) {
		System.out.println(i);
	}*/
	for (int i = 10; i > -1; i=i/2) {
		System.out.println(i);
	}

	}

}
