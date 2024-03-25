// Leetcode 509 Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/description/?envType=study-plan-v2&envId=dynamic-programming

package FibonacciStyle;

class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int c = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }
}