package net.renfei.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 70. 爬楼梯
 * | https://leetcode-cn.com/problems/climbing-stairs/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ClimbingStairs {
    static int sum = 0;

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);
        dp.put(2, 2);
        // 想要到达 n 台阶，可以通过 n-1 或 n-2 个台阶来，所以加起来
        for (int i = 3; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }
}
