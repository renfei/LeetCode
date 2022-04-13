package net.renfei.leetcode.medium;

import java.util.Arrays;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 167. 两数之和 II - 输入有序数组
 * | https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class TwoSumIIinputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            // 找这个需要的数
            int need = target - numbers[i];
            int left = i + 1, right = numbers.length - 1;
            while (left <= right) {
                // 因为是有序的，从中位开始找
                int mid = left + ((right - left) >> 1);
                if (numbers[mid] == need) {
                    // 序号从1开始不是0开始，所以加一
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < need) {
                    // 往右找
                    left = mid + 1;
                } else {
                    // 往左找
                    right = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}
