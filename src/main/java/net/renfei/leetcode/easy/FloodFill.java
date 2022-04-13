package net.renfei.leetcode.easy;

/**
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 * | 733. 图像渲染
 * | https://leetcode-cn.com/problems/flood-fill/
 * +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *
 * @author renfei
 */
public class FloodFill {
    // 代表上下左右
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    public static void dfs(int[][] image, int x, int y, int currColor, int newColor) {
        if (image[x][y] == currColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                // 上下左右搜索
                int newX = dx[i] + x;
                int newY = dy[i] + y;
                // 防止越界
                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length) {
                    dfs(image, newX, newY, currColor, newColor);
                }
            }
        }
    }
}
