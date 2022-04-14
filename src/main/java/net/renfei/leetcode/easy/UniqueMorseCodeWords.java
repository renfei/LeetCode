package net.renfei.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 804. 唯一摩尔斯密码词
 * | https://leetcode-cn.com/problems/unique-morse-code-words/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        String[] map = new String[]{
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-",
                "...-", ".--", "-..-", "-.--", "--.."
        };
        for (String word : words
        ) {
            String newWord = "";
            for (char c : word.toCharArray()
            ) {
                newWord += map[c - 'a'];
            }
            set.add(newWord);
        }
        return set.size();
    }
}
