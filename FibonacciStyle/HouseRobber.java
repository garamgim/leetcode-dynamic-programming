// LeetCode 198 House Robber
// https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=dynamic-programming

package FibonacciStyle;

class HouseRobber {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1) return nums[0];
        if (N == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[N];
        dp[0] = nums[0];
        dp[1] = nums[1];
        if (N > 2) {
            dp[2] = dp[0] + nums[2];
            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
            }
        }
        return Math.max(dp[N - 2], dp[N - 1]);
    }
}