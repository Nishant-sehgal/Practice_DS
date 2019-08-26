package com.practice.hitcounter;

import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		HitCounter hitCounter = new HitCounter();
		System.out.println(" Current Second :: " + hitCounter.getCurrentSecond());
		for (int i = 0; i < 50; i++) {
			hitCounter.hit();
			try {
				Thread.sleep(300);
			} catch (Exception e) {
			}
		}
		hitCounter.getHits();
	}

}

class HitCounter {
	private Deque<Seconds> secondsList;
	private int lastSecond;

	public HitCounter() {
		secondsList = new LinkedList<>();
		Calendar calendar = Calendar.getInstance();
		lastSecond = calendar.get(Calendar.SECOND);
		System.out.println(" Last Second :: " + lastSecond);
	}

	public int getCurrentSecond() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.SECOND);
	}

	public void hit() {
		int currentSecond = getCurrentSecond();
		System.out.println(" Hit Second :: " + currentSecond);
		if (!secondsList.isEmpty() && secondsList.peekLast().sec == currentSecond) {
			secondsList.getLast().count++;
		} else {
			lastSecond = currentSecond;
			secondsList.offer(new Seconds(currentSecond));
		}

	}

	public void getHits() {
		System.out.println(secondsList);
	}
}

class Seconds {
	long count;
	int sec;

	public Seconds(int sec) {
		this.count = 1;
		this.sec = sec;
	}

	@Override
	public String toString() {
		return "Seconds [count=" + count + ", sec=" + sec + "]";
	}
}