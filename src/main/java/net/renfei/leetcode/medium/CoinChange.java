package net.renfei.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 322. 零钱兑换
 * | https://leetcode-cn.com/problems/coin-change/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class CoinChange {
    // 加个备忘录，不加的话 LeetCode 执行超时
    static Map<Integer, Integer> dpTable = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        return f(amount, coins);
    }

    public static int f(int n, int[] coins) {
        // 加个备忘录，不加的话 LeetCode 执行超时
        if (dpTable.containsKey(n)) {
            return dpTable.get(n);
        }
        if (n == 0) return 0;
        if (n < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            // 子问题，把每种钱的情况都尝试一遍
            int sub = f(n - coins[i], coins);
            // 子问题无解，跳过
            if (sub == -1) {
                continue;
            }
            // 选择最优的
            res = Math.min(res, sub + 1);
        }
        if (res != Integer.MAX_VALUE) {
            dpTable.put(n, res);
            return res;
        }
        dpTable.put(n, -1);
        return -1;
    }
}
