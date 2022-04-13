package net.renfei.leetcode.medium;

import java.util.*;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 380. O(1) 时间插入、删除和获取随机元素
 * | https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class InsertDeleteGetrandomO1 {
    Map<Integer, Integer> map;
    List<Integer> list;

    /**
     * 看似 增删查改 关键在于要 O(1) 时间
     * 这就需要结合List和HashMap的优点才能做到
     *
     * @param args
     */
    public static void main(String[] args) {
        InsertDeleteGetrandomO1 insertDeleteGetrandomO1 = new InsertDeleteGetrandomO1();
    }

    public InsertDeleteGetrandomO1() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 先把List最后的拿出来
        int lastIndex = list.size() - 1;
        int lastElement = list.get(lastIndex);
        // 拿出要删除的位置
        int oldIndex = map.get(val);
        // 将 List 最后的元素 覆盖 到要删除的位置
        list.set(oldIndex, lastElement);
        map.put(lastElement, oldIndex);
        // 删除数组最后的
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
