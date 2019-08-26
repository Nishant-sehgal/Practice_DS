package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Connected cell in a grid
 *
 * @author MMT5680
 *
 *Input
 *
 *
4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

 */
public class ConnectedCellInGrid {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		Map<String, Boolean> map = new HashMap<>();
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
				map.put(grid_i + "" + grid_j, false);
			}
		}
		System.out.println(region(n, m, grid, 0, map));
		in.close();
	}

	public static int region(int n, int m, int grid[][], int count, Map<String, Boolean> map) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1 & !map.get(i + "" + j)) {
					int val = checkEachCordinate(n, m, grid, 0, i, j, map);
					if (val > max) {
						max = val;
					}
				}
			}
		}
		return max;
	}

	public static int checkEachCordinate(int n, int m, int grid[][], int count, int k, int l,
			Map<String, Boolean> map) {
		if (k >= 0 && k < n && l >= 0 && l < m) {
			if (grid[k][l] == 1 && !map.get(k + "" + l)) {
				map.put(k + "" + l, true);
				count++;
				// vertical up
				count = checkEachCordinate(n, m, grid, count, k - 1, l, map);
				// vertical down
				count = checkEachCordinate(n, m, grid, count, k + 1, l, map);
				// horizontal right
				count = checkEachCordinate(n, m, grid, count, k, l + 1, map);
				// horizontal left
				count = checkEachCordinate(n, m, grid, count, k, l - 1, map);
				// diagonal right up
				count = checkEachCordinate(n, m, grid, count, k - 1, l + 1, map);
				// diagonal right down
				count = checkEachCordinate(n, m, grid, count, k + 1, l - 1, map);
				// diagonal left up
				count = checkEachCordinate(n, m, grid, count, k - 1, l - 1, map);
				// diagonal left down
				count = checkEachCordinate(n, m, grid, count, k + 1, l + 1, map);
			}
		}
		return count;
	}
}
