package net.renfei.leetcode.easy.jianzhioffer;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 剑指 Offer 05. 替换空格
 * | https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
}
