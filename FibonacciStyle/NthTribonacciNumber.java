package FibonacciStyle;
// LeetCode 1137 N-th Tribonacci Number
// https://leetcode.com/problems/n-th-tribonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming

class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int a = 0;
        int b = 1;
        int c = 1;
        int d = a + b + c;

        for (int i = 3; i < n; i++) {
            a = b;
            b = c;
            c = d;
            d = a + b + c;
        }
        return d;
    }
}