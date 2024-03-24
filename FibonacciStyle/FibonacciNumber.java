// Leetcode 509 Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming

package FibonacciStyle;

public class FibonacciNumber {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        else {
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }
            return dp[n - 1];
        }
    }
}