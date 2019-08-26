package com.thread;

public class EvenOddPrint {

	public static void main(String[] args) throws InterruptedException {
		MyLock lock = new MyLock();
		Even even = new Even(lock);
		Oddd odd = new Oddd(lock);

		even.start();
		odd.start();
		System.out.println("Done");
	}

}

class MyLock {
	private volatile boolean isOdd = true;

	/**
	 * @return the isOdd
	 */
	public boolean isOdd() {
		return isOdd;
	}

	/**
	 * @param isOdd
	 *            the isOdd to set
	 */
	public void setOdd(boolean isOdd) {
		this.isOdd = isOdd;
	}

}

class Even extends Thread {
	private MyLock lock = null;

	public Even(MyLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (lock.isOdd()) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 2; i <= 100; i += 2) {
				System.out.println(i);
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Oddd extends Thread {
	private MyLock lock = null;

	public Oddd(MyLock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			for (int i = 1; i < 100; i += 2) {
				System.out.println(i);
				lock.setOdd(false);
				lock.notify();
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			lock.notify();
		}
	}
}