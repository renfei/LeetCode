package net.renfei.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 229. 求众数 II
 * | https://leetcode-cn.com/problems/majority-element-ii/
 * | 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = new int[]{
                3, 2, 3
        };
        System.out.println(majorityElement(nums));
    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                // 如果数在容器里，那么统计数量加一
                map.put(num, map.get(num) + 1);
            } else {
                // 如果数不在容器里，那么统计数就是1
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer index : map.keySet()
        ) {
            // 取出容器中所有数
            if (map.get(index) > nums.length / 3) {
                // 符合要求的索引加入列表
                list.add(index);
            }
        }
        return list;
    }
}
