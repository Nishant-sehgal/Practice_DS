package com.hackerrank.dp;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(getWays(4, new long[] { 1, 2, 3 }));
		int s = 4, m = 2;
        System.out.println("Nuber of ways = " + countWays(s, m));
	}

	static long getWays(long n, long[] c) {
		long[] dp = new long[(int) n + 1];
		dp[0] = 1;
		for (int j = 0; j < c.length; j++) {
			for (int i = 1; i <= n; i++) {
				if (c[j] <= i) {
					long index = i - c[j];
					dp[i] += dp[(int) index];
				}
			}
		}
		return dp[(int) n];
	}
	static int countWaysUtil(int n, int m)
    {
        int res[] = new int[n];
        res[0] = 1; res[1] = 1;
        for (int i=2; i<n; i++)
        {
           res[i] = 0;
           for (int j=1; j<=m && j<=i; j++)
             res[i] += res[i-j];
        }
        return res[n-1];
    }

    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m)
    {
        return countWaysUtil(s+1, m);
    }
}
