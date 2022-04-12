package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 509. 斐波那契数
 * | https://leetcode-cn.com/problems/fibonacci-number/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(fib(i));
        }
    }

    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        // 子问题，每个数都是 前面两个数 的和
        return fib(n - 1) + fib(n - 2);
    }
}
