package net.renfei.leetcode.easy.jianzhioffer;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 剑指 Offer 58 - II. 左旋转字符串
 * | https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ZuoXuanZhuanZiFuChuanLcof {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
