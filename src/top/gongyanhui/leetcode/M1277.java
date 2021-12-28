package top.gongyanhui.leetcode;

/**
 * 1277. 统计全为 1 的正方形子矩阵(中等)
 */
public class M1277 {

    private final int[][] matrix = new int[][] {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
    };

    /**
     * 对比221最大正方形一题(by self)
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int colunms = matrix[0].length;
        int[][] dp = new int[rows][colunms];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colunms; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colunms; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
}
