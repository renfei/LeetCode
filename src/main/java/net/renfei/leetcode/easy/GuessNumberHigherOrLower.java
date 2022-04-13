package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 374. 猜数字大小
 * | https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        System.out.println(guessNumber(653));
    }

    public static int guessNumber(int n) {
        int left = 1, right = n;
        if (guess(n) == 0) {
            return n;
        }
        if (guess(1) == 0) {
            return 1;
        }
        for (; ; ) {
            int mid = left + ((right - left) >> 1);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                left = mid;
            } else {
                right = mid;
            }
        }
    }

    private static int guess(int num) {
        int number = 45;
        return Integer.compare(number, num);
    }
}
