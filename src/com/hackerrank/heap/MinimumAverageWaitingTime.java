package com.hackerrank.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumAverageWaitingTime {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int orders = sc.nextInt();
		PriorityQueue<Pizza> pizzaOrder = new PriorityQueue<>(new Comparator<Pizza>() {

			@Override
			public int compare(Pizza o1, Pizza o2) {
				return o1.arrivalTime - o2.arrivalTime;
			}
		});
		for (int i = 0; i < orders; i++) {
			int ipTime = sc.nextInt();
			int prepTime = sc.nextInt();
			Pizza p = new Pizza(ipTime, prepTime);
			pizzaOrder.add(p);
		}

		System.out.println(minWaitingTime(pizzaOrder, orders));
		sc.close();
	}

	public static long minWaitingTime(PriorityQueue<Pizza> pizzaOrder, int orders) {
		PriorityQueue<Pizza> queueOrderTime = new PriorityQueue<>(new Comparator<Pizza>() {

			@Override
			public int compare(Pizza o1, Pizza o2) {
				return o1.preparationTime - o2.preparationTime;
			}
		});
		long waitingTime = 0, elapsedTime = 0;
		while (!pizzaOrder.isEmpty() || !queueOrderTime.isEmpty()) {
			while ((!pizzaOrder.isEmpty() && elapsedTime >= pizzaOrder.peek().arrivalTime)
					|| queueOrderTime.isEmpty()) {
				queueOrderTime.add(pizzaOrder.poll());
			}
			Pizza shortestTimePizza = queueOrderTime.poll();
			long delta = 0;
			if (elapsedTime > shortestTimePizza.arrivalTime) {
				delta = elapsedTime - shortestTimePizza.arrivalTime;
				elapsedTime += shortestTimePizza.preparationTime;
			} else {
				elapsedTime = shortestTimePizza.arrivalTime + shortestTimePizza.preparationTime;
			}
			waitingTime += delta + shortestTimePizza.preparationTime;
		}

		return (waitingTime / orders);
	}
}

class Pizza {
	int arrivalTime;
	int preparationTime;

	public Pizza(int inputTime, int preparationTime) {
		this.arrivalTime = inputTime;
		this.preparationTime = preparationTime;
	}

}
