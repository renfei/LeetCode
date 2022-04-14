package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1672. 最富有客户的资产总量
 * | https://leetcode-cn.com/problems/richest-customer-wealth/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class RichestCustomerWealth {
    public static void main(String[] args) {

    }

    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
