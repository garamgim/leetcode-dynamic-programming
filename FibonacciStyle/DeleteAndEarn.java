// LeetCode 740 Delete and Earn
// https://leetcode.com/problems/delete-and-earn/description/?envType=study-plan-v2&envId=dynamic-programming

package FibonacciStyle;

import java.util.Arrays;

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int N = nums[nums.length - 1];
        int[] counting = new int[N + 1];
        int[] dp = new int[N + 1];
        // counting
        for (int i = 0; i < nums.length; i++) {
            counting[nums[i]]++;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < N + 1; i++) {
            if (i > 4) {
                int p = dp[i-2] + (i*counting[i]);
                int q = Math.max(p, dp[i-3] + (i*counting[i]));
                dp[i] = Math.max(q, dp[i-4] + (i*counting[i]));
            } else if (i > 3) {
                dp[i] = Math.max(dp[i-2] + (i*counting[i]), dp[i-3] + (i*counting[i]));
            } else if (i > 2) {
                dp[i] = dp[i - 2] + (i * counting[i]);
            } else {
                dp[i] = i * counting[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}