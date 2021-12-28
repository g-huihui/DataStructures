package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * 7. 整数反转(简单)
 */
public class M7 {

    public int reverse(int x) {
        boolean flag;   //正负数
        if (x < 0) {
            flag = false;
        } else {
            flag = true;
        }
        String str = Math.abs(x) + "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        str = "";
        for (char aChar : chars) {
            str += aChar;
        }
        try {
            int result = Integer.parseInt(str);
            if (!flag) {
                result = -result;
            }
            return result;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        M7 solution = new M7();
        System.out.println(solution.reverse(1534236469));
    }
}
