package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * @author Gong Yanhui
 * @description 566. 重塑矩阵
 * @date 2022-06-16 17:04:40
 */
public class M566 {

    public static void main(String[] args) {
        M566 m = new M566();
        //int[][] arr = new int[][] {{1, 2}, {3, 4}};
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        int[][] res = m.matrixReshape(arr, 42, 5);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;       // 行
        int col = mat[0].length;    // 列
        int count = col * row;
        if (r * c != count) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < count; i++) {
            res[i / c][i % c] = mat[i / col][i % col];
        }
        return res;
    }
}
