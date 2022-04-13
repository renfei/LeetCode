package net.renfei.leetcode.easy;

import java.util.Arrays;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 977. 有序数组的平方
 * | https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * | 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares(int[] nums) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i] * nums[i];
        }
        // 排序
        Arrays.sort(newArray);
        return newArray;
    }
}
