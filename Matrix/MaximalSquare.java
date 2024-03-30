// LeetCode 221 Maximal Square
// https://leetcode.com/problems/maximal-square/?envType=study-plan-v2&envId=dynamic-programming

package Matrix;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[] dr = new int[]{-1, -1, 0};
        int[] dc = new int[]{0, -1, -1};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            memo[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
        }

        for (int i = 0; i < n; i++) {
            memo[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int curr = -1;
                for (int d = 0; d < 3; d++) {
                    int r = i + dr[d];
                    int c = j + dc[d];
                    if (curr == -1) {
                        curr = memo[r][c];
                    } else {
                        curr = Math.min(curr, memo[r][c]);
                    }
                }
                if (matrix[i][j] == '0') {
                    curr = 0;
                } else {
                    curr += 1;
                }
                memo[i][j] = curr;
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, memo[i][j]);
            }
        }

        return ans * ans;
    }
}
