package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1523. 在区间范围内统计奇数数目
 * | https://leetcode-cn.com/problems/count-odd-numbers-in-an-interval-range/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {

    }

    public static int countOdds(int low, int high) {
        // 大数 - 小数 就是之间的奇数个数
        return pre(high) - pre(low - 1);
    }

    public static int pre(int x) {
        // 把 x 看成基数，+1 这样就可以除以2了
        // 这就拿到了 0 ~ x 之间的基数个数
        // 不是基数就是偶数，所以除以二
        return (x + 1) >> 1;
    }
}
