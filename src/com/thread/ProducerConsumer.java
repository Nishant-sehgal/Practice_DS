package com.thread;

/*
 * why wait called from synchronized block:  a race condition can occur
 * A consumer thread calls take() and sees that the buffer.isEmpty().
Before the consumer thread goes on to call wait(), a producer thread comes along and invokes a full give(), that is, buffer.add(data); notify();
The consumer thread will now call wait() (and miss the notify() that was just called).
If unlucky, the producer thread won't produce more give() as a result of the fact that the consumer thread never wakes up, and we have a dead-lock.

As you can see, an application can be concurrent, but not parallel. This means that it processes more than one task at the same time, but the tasks are not broken down into subtasks.

As you can see, an application can be concurrent, but not parallel. This means that it processes more than one task at the same time, but the tasks are not broken down into subtasks.
An application can also be parallel but not concurrent. This means that the application only works on one task at a time, and this task is broken down into subtasks which can be processed in parallel.
 */

public class ProducerConsumer {
	public static void main(String[] args) {
		int size = 5;
		CustomQueue<Integer> queue = new CustomQueue<>(size);
		Producer pc = new Producer(queue);
		Consumer cs = new Consumer(queue);
		pc.start();
		cs.start();
	}

}

class Producer extends Thread {

	private CustomQueue<Integer> queue = null;

	public Producer(CustomQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {

			try {
				System.out.println("Produced : " + i);
				queue.add(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private CustomQueue<Integer> queue = null;

	public Consumer(CustomQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("CONSUMED : " + queue.remove());
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}