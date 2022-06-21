package top.gongyanhui.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Gong Yanhui
 * @description 36. 有效的数独
 * @date 2022-06-21 16:48:59
 */
public class M36 {

    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            if (!isRow(chars)) {
                return false;
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (!isCol(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isOk(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 判断整行是否无重复
    private boolean isRow(char[] arr) {
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            if (c == '.') {
                continue;
            }
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }

    // 判断整列是否无重复
    private boolean isCol(char[][] arr, int index) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][index] == '.') {
                continue;
            }
            if (!set.add(arr[i][index])) {
                return false;
            }
        }
        return true;
    }

    // 判断3X3是否无重复
    private boolean isOk(char[][] arr, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int m = i; m < i + 3; m++) {
            for (int n = j; n < j + 3; n++) {
                if (arr[m][n] == '.') {
                    continue;
                }
                if (!set.add(arr[m][n])) {
                    return false;
                }
            }
        }
        return true;
    }
}
