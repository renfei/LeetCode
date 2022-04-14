package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 191. 位1的个数
 * | https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000000001011", 2)));
    }

    public static int hammingWeight(int n) {
        int ret = 0;
        // 一共32位，循环每一位
        for (int i = 0; i < 32; i++) {
            // 循环一次向前移动一位，进行比较，是不是 1
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
