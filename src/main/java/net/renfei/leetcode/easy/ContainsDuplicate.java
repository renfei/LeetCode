package net.renfei.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 217. 存在重复元素
 * | https://leetcode-cn.com/problems/contains-duplicate/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ContainsDuplicate {
    static Map<Integer, Object> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i : nums
        ) {
            if (map.containsKey(i)) {
                return true;
            }
            map.put(i, null);
        }
        return false;
    }
}
