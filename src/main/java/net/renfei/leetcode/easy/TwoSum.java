package net.renfei.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1. 两数之和
 * | https://leetcode-cn.com/problems/two-sum/
 * | 给定一个整数数组 nums 和一个整数目标值 target，
 * | 请你在该数组中找出 和为目标值 target 的那两个整数，
 * | 并返回它们的数组下标。
 * | 你可以假设每种输入只会对应一个答案。但是，
 * | 数组中同一个元素在答案里不能重复出现。
 * | 你可以按任意顺序返回答案。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        // +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
        System.out.println("输入： " + Arrays.toString(nums));
        System.out.println("目标： " + target);
        System.out.println("结果： " + Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        // 定义个Map容器存储我们扫描过的元素
        // Key存储元素，Value存储索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 判断容器里是否有满足条件的元素
            if (map.containsKey(target - nums[i])) {
                // 如果有，那么返回容器中的 Value 和 当前元素的索引 i
                return new int[]{map.get(target - nums[i]), i};
            }
            // 没找到，那么就将扫描过的元素放入容器
            map.put(nums[i], i);
        }
        // 遍历了一圈，都没找到就返回个空数组
        return new int[0];
    }
}
