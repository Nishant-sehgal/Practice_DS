package com.thread;

/*
 * if I see nested synchronized block or calling one synchronized method from other or trying
 * to get lock on different object then there is good chance of deadlock if developer is not very careful.
 *
 * to avoid deadlock have some order of locks
 */
public class DeadLockDemo {

	public static void main(String[] args) {

		new Th1().start();
		new Th2().start();

	}

}

class Th1 extends Thread {
	public void method1() throws InterruptedException {
		synchronized (String.class) {
			System.out.println("Aquired lock on String.class object");
			Thread.sleep(1000);
			synchronized (Integer.class) {
				System.out.println("Aquired lock on Integer.class object");
			}
		}
	}

	@Override
	public void run() {
		try {
			method1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Th2 extends Thread {
	public void method2() throws InterruptedException {
		synchronized (Integer.class) {
			Thread.sleep(1000);
			System.out.println("Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println("Aquired lock on String.class object");
			}
		}
	}

	@Override
	public void run() {
		try {
			method2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}