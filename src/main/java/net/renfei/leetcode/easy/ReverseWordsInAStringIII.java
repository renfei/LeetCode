package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 557. 反转字符串中的单词 III
 * | https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        String[] sArray = s.split(" ");
        String res = "";
        for (String string : sArray
        ) {
            char[] charArray = string.toCharArray();
            reverseChar(charArray);
            res += new String(charArray) + " ";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public static void reverseChar(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public static void swap(char[] s, int i, int j) {
        s[i] ^= s[j];
        s[j] ^= s[i];
        s[i] ^= s[j];
    }
}
