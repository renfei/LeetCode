package net.renfei.leetcode.easy;

import java.util.Arrays;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 806. 写字符串需要的行数
 * | https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class NumberOfLinesToWriteString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(new int[]{
                4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
        }, "bbbcccdddaaa")));
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int max = 100;
        int line = 1;
        int width = 0;
        for (int i = 0; i < s.length(); i++) {
            int need = widths[s.charAt(i) - 'a'];
            width += need;
            if (width > max) {
                line++;
                width = need;
            }
        }
        int[] res = new int[2];
        res[0] = line;
        res[1] = width;
        return res;
    }
}
