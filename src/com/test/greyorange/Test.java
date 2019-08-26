package com.test.greyorange;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max_so_far = -10001, max_ending_here = 0;
		int[] temp = new int[n];

		for (int i = 0; i < n; i++) {
			temp[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			max_ending_here = max_ending_here + temp[i];
			if (temp[i] < max_ending_here) {
				temp[i] = max_ending_here;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}

		SegmentTree st = new SegmentTree(n, temp);

		int q = sc.nextInt();
		for (int j = 0; j < q; j++) {
			int r = sc.nextInt();
			int s = sc.nextInt();
			int idx = st.rmq(r, s);
			if (r > 1) {
				System.out.println(st.a[idx] - temp[r - 1]);
			} else {
				System.out.println(st.a[idx]);
			}
		}
	}
}

class SegmentTree {
	int n;
	int[] s, a;

	public SegmentTree(int n, int[] temp) {
		this.n = n;
		this.a = temp;
		this.s = new int[4 * n];
		build(1, 0, n - 1);
	}

	// same as binary heap operations
	public int left(int p) {
		return p << 1;
	}

	public int right(int p) {
		return (p << 1) + 1;
	}

	// O(n)
	public void build(int p, int l, int r) {
		if (l == r)
			s[p] = l; // store the index
		else { // recursively compute the values
			build(left(p), l, (l + r) / 2);
			build(right(p), ((l + r) / 2) + 1, r);
			int p1 = s[left(p)];
			int p2 = s[right(p)];
			s[p] = a[p1] >= a[p2] ? p1 : p2;
		}
	}

	// O(logn)
	public int rmq(int p, int l, int r, int i, int j) {
		if (i > r || j < l)
			return -1; // segment outside query range
		if (l >= i && r <= j)
			return s[p]; // inside query range

		// compute the min position in the left and right
		// part of the interval
		int p1 = rmq(left(p), l, (l + r) / 2, i, j);
		int p2 = rmq(right(p), ((l + r) / 2) + 1, r, i, j);

		if (p1 == -1)
			return p2; // if we try to access segement outside query
		if (p2 == -1)
			return p1; // same as above

		return a[p1] >= a[p2] ? p1 : p2; // as in build routine
	}

	public int rmq(int i, int j) {
		return rmq(1, 0, n - 1, i, j);
	}
}