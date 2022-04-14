package net.renfei.leetcode.medium;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 1254. 统计封闭岛屿的数目
 * | https://leetcode-cn.com/problems/number-of-closed-islands/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class NumberOfClosedIslands {
    private int m, n;
    private int ans = 0;  //保存 最终答案
    private int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; //偏移量

    public static void main(String[] args) {

    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;               //保存地图边长
        if (m <= 2 || n <= 2) return 0;    //特判，地图有一边长不大于2都不可能有封闭岛屿
        for (int i = 1; i < m - 1; i++)        //由于我们要统计的是封闭岛屿，所以我们可以只遍历不含边界的地块，进一步提升效率
            for (int j = 1; j < n - 1; j++)
                if (grid[i][j] == 0)
                    if (dfs(grid, i, j)) ans++;  //dfs这个区域
        return ans;
    }

    public boolean dfs(int[][] grid, int x, int y)   //返回值为布尔值。false表示当前岛屿是不封闭状态
    {
        if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && grid[x][y] == 0) return false;    //如果当前为边界并且是陆地直接返回false
        boolean f = true;                   //作为当前dfs分支的返回值
        grid[x][y] = 1;                     //标记为海洋
        for (int i = 0; i < 4; i++)           //向四个方向遍历
        {
            int x1 = x + dx[i], y1 = y + dy[i];
            if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1) continue;
            f = f & dfs(grid, x1, y1);       //关键步骤，与运算
        }
        return f;
    }
}
