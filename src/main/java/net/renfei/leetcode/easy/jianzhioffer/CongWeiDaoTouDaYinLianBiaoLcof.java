package net.renfei.leetcode.easy.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 剑指 Offer 06. 从尾到头打印链表
 * | https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {

    }

    /**
     * 我这个写法有点low，但第一个想法，直接就这样写了
     * 倒序也可以用栈
     */
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tem = head;
        while (tem != null) {
            list.add(tem.val);
            tem = tem.next;
        }
        int[] arr = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = list.get(i);
        }
        return arr;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
