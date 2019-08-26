package com.hackerrank.dailycodeproblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day10JobScheduler {

	private static MyExecutor executorService = new MyExecutor(3);

	public static void main(String[] args) {
		executorService.submit(new MyTask(3000) {
			@Override
			public void run() {

				System.out.println("Task 1");
			}
		});
		executorService.submit(new MyTask(1000) {
			@Override
			public void run() {

				System.out.println("Task 2");
			}
		});
		executorService.submit(new MyTask(2000) {
			@Override
			public void run() {

				System.out.println("Task 3");
			}
		});

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}

abstract class MyTask implements Runnable {

	private Long delay;

	public MyTask(long delay) {
		this.delay = System.currentTimeMillis() + delay;
	}

	/**
	 * @return the delay
	 */
	public Long getDelay() {
		return delay;
	}

}

class MyExecutor {

	private int threads;
	private MyQueue<MyTask> queue = new MyQueue<>();
	private List<Worker> workerList = new ArrayList<>();

	MyExecutor(int threads) {
		this.threads = threads;
		createWorker();
	}

	public void submit(MyTask task) {
		queue.add(task);
	}

	public void createWorker() {
		for (int i = 0; i < threads; i++) {
			Worker worker = new Worker(queue);
			Thread thread = new Thread(worker);
			thread.start();
			workerList.add(worker);
		}
	}

	public void shutdown() {
		queue.exit(false);
		for (Worker worker : workerList) {
			worker.shutDown();
		}
	}
}

class MyQueue<T> {
	private volatile boolean exitFlag = true;
	private PriorityQueue<T> queue = new PriorityQueue<>(new Comparator<T>() {

		@Override
		public int compare(T o1, T o2) {
			return ((MyTask) o1).getDelay().compareTo(((MyTask) o2).getDelay());
		}

	});

	public T remove() throws InterruptedException {
		while (exitFlag) {
			synchronized (this) {
				while (queue.isEmpty() && exitFlag) {
					wait();
				}
				T run = queue.remove();
				notifyAll();
				return run;
			}
		}
		return null;
	}

	public void add(T run) {
		synchronized (this) {
			queue.add(run);
			notifyAll();
		}
	}

	public T peek() throws InterruptedException {
		while (exitFlag) {
			synchronized (this) {
				while (queue.isEmpty() && exitFlag) {
					wait();
				}
				return queue.peek();
			}
		}
		return null;
	}

	public void exit(boolean exitFlag) {
		this.exitFlag = exitFlag;
		synchronized (this) {
			notifyAll();
		}
	}

}

class Worker implements Runnable {

	private MyQueue<MyTask> queue;
	private volatile boolean shutdown = false;

	public Worker(MyQueue<MyTask> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (!shutdown) {
			try {
				synchronized (queue) {
					MyTask myTask = queue.peek();
					boolean val = myTask != null ? (queue.peek().getDelay() - System.currentTimeMillis() <= 0) : false;
					if (val) {
						Runnable task = queue.remove();
						if (task != null) {
							task.run();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutDown() {
		this.shutdown = true;
	}

}