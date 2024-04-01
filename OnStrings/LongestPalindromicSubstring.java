// LeetCode 5 Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=dynamic-programming

package OnStrings;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] memo = new boolean[N][N];
        int ansS = 0;
        int ansE = 0;

        for (int i = 0; i < N; i++) {
            memo[i][i] = true;
        }

        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                memo[i][i+1] = true;
                ansS = i;
                ansE = i+1;
            }
        }

        for (int itv = 2; itv < N; itv++) {
            for (int i = 0; i < N - itv; i++) {
                int j = i + itv;
                if ((s.charAt(i) == s.charAt(j)) && memo[i+1][j-1]) {
                    memo[i][j] = true;
                    ansS = i;
                    ansE = j;
                }
            }
        }

        return s.substring(ansS, ansE + 1);
    }
}
