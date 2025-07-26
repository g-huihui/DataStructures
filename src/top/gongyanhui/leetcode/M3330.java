package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 3330. 找到初始输入字符串 I
 * @Date: 2025-07-26 22:51
 */

class M3330 {

    // 官方 GO解法 翻译 JAVA
    public int possibleStringCount(String word) {
        int res = 1;    // 代表没有出错情况下 原始字符串本身 一种可能
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) { // 如果当前位置和前一个位置相同 则多一次可能
                res++;
            }
        }

        return res;
    }
}
