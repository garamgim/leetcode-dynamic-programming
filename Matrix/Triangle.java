package Matrix;

// LeetCode 120 Triangle
// https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int r = triangle.size();
        int[][] memo = new int[r][r];

        for (int i = 0; i < r; i++) {
            memo[r-1][i] = triangle.get(r-1).get(i);
        }

        for (int i = r - 2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            int[] prev = memo[i+1];
            for (int j = 0; j < curr.size(); j++) {
                memo[i][j] = curr.get(j) + Math.min(prev[j], prev[j+1]);
            }
        }

        return memo[0][0];
    }
}