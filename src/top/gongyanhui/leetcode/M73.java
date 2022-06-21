package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * @author Gong Yanhui
 * @description 73. 矩阵置零
 * @date 2022-06-21 16:54:22
 */
public class M73 {

    public static void main(String[] args) {
        M73 m = new M73();

        int[][] arr1 = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        m.setZeroes(arr1);
        for (int[] ints : arr1) {
            System.out.println(Arrays.toString(ints));
        }

        int[][] arr2 = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        m.setZeroes(arr2);
        for (int[] ints : arr2) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) {
                row2Zero(matrix, i);
            }
        }

        for (int i = 0; i < col.length; i++) {
            if (col[i]) {
                col2Zero(matrix, i);
            }
        }
    }

    private void row2Zero(int[][] arr, int index) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[index][i] = 0;
        }
    }

    private void col2Zero(int[][] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][index] = 0;
        }
    }
}
