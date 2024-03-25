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
        dp[1] = counting[1];
        int ans = dp[1];
        for (int i = 2; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i*counting[i]);
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }
}