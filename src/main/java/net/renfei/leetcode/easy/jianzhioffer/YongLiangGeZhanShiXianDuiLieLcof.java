package net.renfei.leetcode.easy.jianzhioffer;

import java.util.Stack;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 剑指 Offer 09. 用两个栈实现队列
 * | https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(6);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }

    /**
     * 两个栈，进的时候进 inStack
     * 出的时候出 outStack
     * outStack 出完以后，把 inStack 倒出来给 outStack
     */
    static class CQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public CQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void appendTail(int value) {
            inStack.push(value);
        }

        public int deleteHead() {
            if (outStack.isEmpty()) {
                if (inStack.isEmpty()) {
                    return -1;
                }
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
            return outStack.pop();
        }
    }
}
