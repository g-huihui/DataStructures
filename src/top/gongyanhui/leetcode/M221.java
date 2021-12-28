package top.gongyanhui.leetcode;

/**
 * 221. 最大正方形(中等)
 */
public class M221 {

    private final char[][] matrix = new char[][] {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
    };

    /**
     * 方法1: 暴力求解
     *  遍历矩阵，遇到1则作为假设正方形的左上角；
     *  根据左上角所在的行和列，计算出可能的最大正方形；
     *  每次循环在下方一行和右方一列验证是否所有元素都为1。
     * @param matrix
     * @return  最大正方形的面积
     */
    public int maximalSquare1(char[][] matrix) {
        //首先判断矩阵是否为空
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSize = 0;                //最大边长
        int rows = matrix.length;       //矩阵的行数
        int columns = matrix[0].length; //矩阵的列数
        //循环矩阵中每一个元素
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                //遇到一个1 则作为矩阵的左上角
                maxSize = Math.max(maxSize, 1);
                //计算可能的最大正方形的边长
                int currentMaxSize = Math.min(rows - i, columns - j);
                for (int k = 1; k < currentMaxSize; k++) {
                    boolean flag = true;
                    //判断新增的一行一列是否全为1
                    if (matrix[i + k][j + k] == '0') {
                        break;
                    }
                    for (int m = 0; m < k; m++) {
                        if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        maxSize = Math.max(maxSize, k + 1);
                    } else {
                        break;
                    }
                }
            }
        }
        return maxSize * maxSize;
    }

    /**
     * 方法2: 动态规划
     *  使用dp(i,j)表示以(i,j)为右下角，且只包含1的正方形的边长最大值。如果我们能计算出所有dp(i,j)）的值，那么其中的最大值即为矩阵中只
     *  包含1的正方形的边长最大值，其平方即为最大正方形的面积。
     *
     *  如何计算 dp 中的每一个元素值：
     *      •若该位置的值为0，则 dp(i,j) = 0，因为当前位置不可能在由 1 组成的正方形中；
     *      •若该位置的值为1，则 dp(i,j）的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
     *       具体而言，当前位置的元素值等于三个相邻的元素中的最小值加 1，状态转移方程如下：
     * dp(i, j) = min(dp(i - 1, j), dp((i - 1),(j - 1)), dp(i, j - 1)) + 1
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        //首先判断矩阵是否为空
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxSize = 0;                //最大边长
        int rows = matrix.length;       //矩阵的行数
        int columns = matrix[0].length; //矩阵的列数

        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
}
