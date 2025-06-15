package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 2566. 替换一个数字后的最大差值
 * @Date: 2025-06-15 13:05
 */
public class M2566 {


    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        String minStr, maxStr = str;

        // 从左到右找到第一个不是9的数字 将所有该数字替换为9 获取最大值
        int index = 0;
        while (index < str.length() && str.charAt(index) == '9') {
            index++;
        }
        if (index < str.length()) {
            maxStr = str.replace(str.charAt(index), '9');
        }

        // 从左到右找到第一个不是0的数字 将所有该数字替换为0 获取最小值 由于第一个不可能为0 直接替换第一个即可
        minStr = str.replace(str.charAt(0), '0');

        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }

    public static void main(String[] args) {
        M2566 m = new M2566();
        System.out.println(m.minMaxDifference(11891));  // 99899 - 890 = 99009
        System.out.println(m.minMaxDifference(90));     // 99 - 0 = 99
    }
}
