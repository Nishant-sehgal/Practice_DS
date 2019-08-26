package com.thread;

public class CustomThreadPool {

	public static void main(String[] args) {
		Pool threadPool = new Pool(3, 4);
		// Created 15 Tasks and submit to pool
		for (int taskNumber = 1; taskNumber <= 7; taskNumber++) {
			TestTask task = new TestTask(taskNumber);
			try {
				threadPool.submit(task);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Pool {
	private CustomQueue<Runnable> q = null;
	private int size;

	public Pool(int size, int threads) {
		this.size = size;
		q = new CustomQueue<>(4);
		for (int i = 0; i < threads; i++) {
			Thread t = new Thread(new Task(q));
			t.start();
		}
	}

	public void submit(Runnable run) throws InterruptedException {
		q.add(run);
	}
}

class Task implements Runnable {

	private CustomQueue<Runnable> q = null;

	Task(CustomQueue<Runnable> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while (true) {
				String name = Thread.currentThread().getName();
				Runnable task = null;
				try {
					task = q.remove();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Task Started by Thread :" + name);
				task.run();
				System.out.println("Task Finished by Thread :" + name);
		}
	}

}

class TestTask implements Runnable {
	private int number;

	public TestTask(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		System.out.println("Start executing of task number :" + number);
		try {
			// Simulating processing time
			// perform tasks
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End executing of task number :" + number);
	}
}