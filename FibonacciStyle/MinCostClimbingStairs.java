// LeetCode 746 Min Cost Climbing Stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming

package FibonacciStyle;

class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        dp[0] = cost[0];
        dp[1] = cost[1];
        if (N > 2) {
            for (int i = 2; i < N; i++) {
                dp[i] = Math.min(dp[i - 2] + cost[i], dp[i - 1] + cost[i]);
            }
        }
        return Math.min(dp[N - 2], dp[N - 1]);
    }
}