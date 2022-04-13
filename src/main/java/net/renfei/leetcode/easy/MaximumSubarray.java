package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 53. 最大子数组和
 * | https://leetcode-cn.com/problems/maximum-subarray/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int curr : nums) {
            // 当前和前一个相加，并和当前比较，如果相加之后还比当前小了，那么放弃前一个，从当前开始
            pre = Math.max(pre + curr, curr);
            // 记录历史中出现最大的和
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
