package com.hackerrank.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetrolPumpCircle {

	public static void main(String[] args) {
		List<TruckDetail> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int operations = sc.nextInt();
		for (int i = 0; i < operations; i++) {
			int petrol = sc.nextInt();
			int distance = sc.nextInt();
			list.add(new TruckDetail(distance, petrol));
		}
		System.out.println(startIndex(list));
		sc.close();

	}

	static int startIndex(List<TruckDetail> list) {
		int petrol = 0;
		int start = 0, end = list.size()-1;
		int i = 0;
		while (start != end) {
			TruckDetail detail = list.get(start);
			if (detail.petrol + petrol >= detail.distance) {
				petrol = petrol + detail.petrol - detail.distance;
			} else {
				end = start;
				petrol = 0;
				i++;
				if(i == list.size()) {
					return -1;
				}
			}
			start = (start + 1) % list.size();
		}
		return (end + 1) % list.size();
	}

}

class TruckDetail {
	int distance;
	int petrol;

	/**
	 * @param distance
	 * @param petrol
	 */
	public TruckDetail(int distance, int petrol) {
		super();
		this.distance = distance;
		this.petrol = petrol;
	}

}
