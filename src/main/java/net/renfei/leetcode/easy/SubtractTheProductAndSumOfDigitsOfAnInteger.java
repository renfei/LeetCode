package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1281. 整数的各位积和之差
 * | https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    public static int subtractProductAndSum(int n) {
        char[] string = (n + "").toCharArray();
        int he = 0, ji = 1;
        for (char c : string
        ) {
            he += Integer.parseInt(c + "");
            ji *= Integer.parseInt(c + "");
        }
        return ji - he;
    }
}
