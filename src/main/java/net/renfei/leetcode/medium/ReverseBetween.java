package net.renfei.leetcode.medium;

import static net.renfei.leetcode.medium.ReverseList.reverseList;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 92. 反转链表 II
 * | https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * | 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * | 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ReverseBetween {
    /**
     * 此题需要先弄明白 206. 反转链表
     * src/main/java/net/renfei/leetcode/medium/ReverseList.java
     * 然后根据 left 和 right 进行裁剪，裁剪出来的进行反转
     * 反转以后再接回来
     *
     * @param args
     */
    public static void main(String[] args) {
        ReverseList.ListNode head = new ReverseList.ListNode(1,
                new ReverseList.ListNode(2,
                        new ReverseList.ListNode(3,
                                new ReverseList.ListNode(4,
                                        new ReverseList.ListNode(5))))
        );
        ReverseList.ListNode newHead = reverseBetween(head, 2, 4);
        while (newHead != null) {
            System.out.println(newHead);
            newHead = newHead.next;
        }
    }

    public static ReverseList.ListNode reverseBetween(ReverseList.ListNode head, int left, int right) {
        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ReverseList.ListNode dummyNode = new ReverseList.ListNode(-1);
        dummyNode.next = head;

        ReverseList.ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ReverseList.ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ReverseList.ListNode leftNode = pre.next;
        ReverseList.ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        // src/main/java/net/renfei/leetcode/medium/ReverseList.java
        reverseList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }
}
