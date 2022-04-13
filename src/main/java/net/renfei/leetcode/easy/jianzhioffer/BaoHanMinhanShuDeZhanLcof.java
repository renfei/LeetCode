package net.renfei.leetcode.easy.jianzhioffer;

import java.util.Stack;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 剑指 Offer 30. 包含min函数的栈
 * | https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class BaoHanMinhanShuDeZhanLcof {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(4);
        obj.push(1);
        obj.push(5);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.min());
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
     * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
     */
    static class MinStack {
        /**
         * 两个栈，只要栈顶的没出去，那么这个元素下面的就一定在，
         * 所以记录每个元素下面最小值即可
         */
        // 主栈，用来存数据
        Stack<Integer> main;
        // 辅助栈，用来存最小值
        Stack<Integer> min;

        public MinStack() {
            main = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            main.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                // 谁小入谁
                min.push(Math.min(x, min.peek()));
            }
        }

        public void pop() {
            main.pop();
            min.pop();
        }

        public int top() {
            return main.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
