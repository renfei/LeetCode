package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 2. 两数相加
 * | https://leetcode-cn.com/problems/add-two-numbers/
 * | 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按
 * | 照逆序的方式存储的，并且每个节点只能存储一位数字。
 * | 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * | 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println("输入l1： " + l1);
        System.out.println("输入l2： " + l2);
        System.out.println("输出： " + addTwoNumbers(l1, l2));
    }

    /**
     * 由于输入的两个链表都是逆序存储数字的位数的，因此两个链表中同一位置的数字可以直接相加。
     * 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
     * 具体而言，如果当前两个链表处相应位置的数字为 n1,n2，进位值为 carry，则它们的和为 n1+n2+carry；
     * 其中，答案链表处相应位置的数字为 (n1+n2+carry)mod10。
     * 如果两个链表的长度不同，则可以认为长度短的链表的后面有若干个 0。
     * 此外，如果链表遍历结束后，有 carry>0，还需要在答案链表的后面附加一个节点，节点的值为 carry。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新链条的头和尾
        ListNode head = null, tail = null;
        // 进位
        int carry = 0;
        // 两个链表可能长度不同，所以是或的关系，只要有一个有内容那就继续遍历
        while (l1 != null || l2 != null) {
            // 两个链表可能长度不同，为空的用 0 代替补齐
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 求和
            int sum = n1 + n2 + carry;
            if (head == null) {
                // 如果头是空，那么就是新链，头=尾=new ListNode
                head = tail = new ListNode(sum % 10);
            } else {
                // 否则给链条后面续接上新的 Node
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // 获得进位，因为是倒序，参与下次求和计算
            carry = sum / 10;
            if (l1 != null) {
                // 向后移动l1的指针
                l1 = l1.next;
            }
            if (l2 != null) {
                // 向后移动l2的指针
                l2 = l2.next;
            }
        }
        // 此处易错，进位大于0的情况
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
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
