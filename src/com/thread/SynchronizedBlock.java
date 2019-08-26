package com.thread;

public class SynchronizedBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeastB b = new TeastB();
		TestA a = new TestA(b);
		TestC c = new TestC(b);
		a.start();
		c.start();
	}

}

class TeastB {
	 void methodA() throws InterruptedException {
		 synchronized(this){
		Thread.sleep(2000);
		System.out.println("A");
		 }
	}

	synchronized void methodB() throws InterruptedException {
		synchronized(this){
		Thread.sleep(2000);
		System.out.println("B");
		}
	}
}

class TestA extends Thread {
	TeastB b = null;

	public TestA(TeastB b) {
		this.b = b;
	}

	@Override
	public void run() {
		try {
			System.out.println("TestA");
			b.methodB();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class TestC extends Thread {
	TeastB b = null;

	public TestC(TeastB b) {
		this.b = b;
	}

	@Override
	public void run() {
		try {
			System.out.println("TestB");
			b.methodA();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}