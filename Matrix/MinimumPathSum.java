// LeetCode 64 Minimum Path Sum
// https://leetcode.com/problems/minimum-path-sum/?envType=study-plan-v2&envId=dynamic-programming

package Matrix;

class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }

        return grid[m-1][n-1];
    }
}
