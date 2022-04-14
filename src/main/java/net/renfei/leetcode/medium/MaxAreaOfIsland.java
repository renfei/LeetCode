package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 695. 岛屿的最大面积
 * | https://leetcode-cn.com/problems/max-area-of-island/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class MaxAreaOfIsland {
    static int temp = 0;

    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // 计数归零
                    temp = 0;
                    // 深度搜索
                    dfs(grid, i, j);
                    // 选最大的面积，记录下来
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }

    /**
     * 深度优先搜索，搜索上下左右连着的陆地
     */
    public static void dfs(int[][] grid, int x, int y) {
        int maxX = grid.length - 1, maxY = grid[0].length - 1;
        // 防止越界，终止搜索
        if (x < 0 || y < 0 || x > maxX || y > maxY || grid[x][y] == 0) {
            return;
        }
        // 找到就加一计数
        temp++;
        // 设置为已经找过
        grid[x][y] = 0;
        // 搜索上下左右挨着的陆地
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
