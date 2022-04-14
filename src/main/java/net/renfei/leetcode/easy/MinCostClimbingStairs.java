package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 746. 使用最小花费爬楼梯
 * | https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        // 前两步免费
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            // 每一层都可以由 n-1 或 n-2 来，那么就选最便宜的
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
