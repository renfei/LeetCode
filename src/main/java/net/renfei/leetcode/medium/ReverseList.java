package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 206. 反转链表
 * | https://leetcode-cn.com/problems/reverse-linked-list/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3))
        );
        ListNode newHead = reverseList(head);
        while (newHead != null) {
            System.out.println(newHead);
            newHead = newHead.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 将当前节点的后继保存一下
            ListNode next = curr.next;
            // 当前节点的后继改为 prev
            curr.next = prev;
            // prev 设置为当前节点
            prev = curr;
            // 当前节点改为原来当前节点的下一个节点，循环继续
            curr = next;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
