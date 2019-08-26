package com.thread;

public class ThreadKillAfterTimeout {

	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1(System.currentTimeMillis() + 5000);
		t1.start();
		// Thread.sleep(5000);
		// t1.setKillSignal(true);

	}

}

class Thread1 extends Thread {
	private volatile boolean killSignal;
	private long ttl;

	public Thread1(long ttl) {
		this.ttl = ttl;
	}

	/**
	 * @param killSignal
	 *            the killSignal to set
	 */
	public void setKillSignal(boolean killSignal) {
		this.killSignal = killSignal;
	}

	@Override
	public void run() {
		while (System.currentTimeMillis() < ttl && !killSignal) {
			System.out.println("doing");
		}
		if (killSignal) {
			System.out.println("killed");
		} else {
			System.out.println("respond");
		}
	}
}