package com.hackerrank.code.week35;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LuckyPurchase {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<ProductDetail> productList = new ArrayList<>();
		for (int a0 = 0; a0 < n; a0++) {
			String s = in.next();
			int price = in.nextInt();
			productList.add(new ProductDetail(s, price));
		}
		bestPrice(productList);
		in.close();
	}

	public static void bestPrice(List<ProductDetail> productList) {
		int min = Integer.MAX_VALUE;
		String output = "";
		for (ProductDetail productDetail : productList) {
			if (checkForEqualDigits(productDetail.getPrice())) {
				if (productDetail.getPrice() < min) {
					min = productDetail.getPrice();
					output = productDetail.getName();
				}
			}
		}
		if (output == "") {
			System.out.println(-1);
		}
		else{
			System.out.println(output);
		}
	}

	public static boolean checkForEqualDigits(Integer number) {
		int count4 = 0;
		int count7 = 0;
		while (number % 10 != 0) {
			int temp = number % 10;
			if (temp == 4) {
				count4++;
			} else if (temp == 7) {
				count7++;
			} else {
				return false;
			}
			number = number / 10;
		}
		if (count4 == count7 && count4 != 0 && count7 != 0) {
			return true;
		}
		return false;
	}
}

class ProductDetail {
	private String name;
	private Integer price;

	/**
	 * @param name
	 * @param price
	 */
	public ProductDetail(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

}