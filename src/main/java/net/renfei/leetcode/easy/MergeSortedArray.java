package net.renfei.leetcode.easy;

import java.util.Arrays;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 88. 合并两个有序数组
 * | https://leetcode-cn.com/problems/merge-sorted-array/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
