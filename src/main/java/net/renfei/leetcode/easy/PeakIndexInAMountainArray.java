package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 852. 山脉数组的峰顶索引
 * | https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class PeakIndexInAMountainArray {
    public static void main(String[] args) {

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                index = i;
                max = arr[i];
            }
        }
        return index;
    }
}
