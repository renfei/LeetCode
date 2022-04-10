package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 807. 保持城市天际线
 * | https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };
        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        // 先做一个 X，Y 轴的投影，取最高的值
        int[] rowMax = new int[grid.length];
        int[] colMax = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // X，Y 轴取最小的值，不能超过这个值，否则影响投影
                // 然后最小的值和现在的值 差值 就是可以提升的最大高度
                max += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return max;
    }
}
