package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 883. 三维形体投影面积
 * @date 2022-04-26 16:32:45
 */
public class M883 {

    public static int projectionArea(int[][] grid) {
        int area = 0;
        int maxY = 0;
        int[] record = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = grid[i][j];
                //底部阴影面积
                if (num > 0) {
                    area++;
                }

                // 投影到x的面积
                if (i == 0) {
                    area += num;
                    record[j] = num;
                } else {
                    int temp = num - record[j];
                    if (temp > 0) {
                        area += temp;
                        record[j] = num;
                    }
                }

                // 投影到y的面积
                if (j == 0) {
                    area += num;
                    maxY = num;
                } else {
                    int temp = num - maxY;
                    if (temp > 0) {
                        area += temp;
                        maxY = num;
                    }
                }

            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][] {{1, 2}, {3, 4}}));
    }
}
