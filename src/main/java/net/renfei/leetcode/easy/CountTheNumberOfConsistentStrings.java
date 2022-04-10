package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1684. 统计一致字符串的数目
 * | https://leetcode-cn.com/problems/count-the-number-of-consistent-strings/
 * | 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。
 * | 如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是一致字符串。
 * | 请你返回 words 数组中 一致字符串 的数目。
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        String[] arr = new String[]{
                "ad", "bd", "aaab", "baa", "badab"
        };
        System.out.println(countConsistentStrings("ab", arr));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        // 字符串都是由26个字母构成的，映射到一个数组中
        int[] map = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            map[allowed.charAt(i) - 'a'] = 1;
        }
        int total = 0;
        for (String word : words) {
            boolean find = true;
            for (int j = 0; j < word.length(); j++) {
                if (map[word.charAt(j) - 'a'] != 1) {
                    // 只要有一个字符没找到，那么就不算
                    find = false;
                    break;
                }
            }
            if (find) {
                total++;
            }
        }
        return total;
    }
}
