package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 200. 岛屿数量
 * | https://leetcode-cn.com/problems/number-of-islands/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class NumberOfIslands {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // 找到一块陆地
                    res++;
                    // 深度优先，搜索整块挨着的陆地
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索，将上下左右挨着的1设置为0
     * 这样就将一整块陆地扫描完成，变成大海
     */
    public static void dfs(char[][] grid, int x, int y) {
        int maxX = grid.length - 1;
        int maxY = grid[0].length - 1;
        // 防止越界，终止搜索
        if (x < 0 || y < 0 || x > maxX || y > maxY || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        // 搜索上下左右
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
    }
}
