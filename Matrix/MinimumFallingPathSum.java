// Leetcode 931 Minimum Falling Path Sum
// https://leetcode.com/problems/minimum-falling-path-sum/?envType=study-plan-v2&envId=dynamic-programming

package Matrix;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            memo[0][i] = matrix[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minPast = Integer.MAX_VALUE;
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k < n) {
                        minPast = Math.min(minPast, memo[i-1][j+k]);
                    }
                }
                memo[i][j] = matrix[i][j] + minPast;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(memo[n-1][i], ans);
        }

        return ans;
    }
}
