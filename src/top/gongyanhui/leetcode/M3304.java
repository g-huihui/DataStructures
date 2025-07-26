package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 3304. 找出第 K 个字符 I
 * @Date: 2025-07-26 23:13
 */

public class M3304 {

    // 自己完成
    public char kthCharacter(int k) {
        String str = "a";
        while (str.length() < k) {
            str += getNextString(str);
        }
        return str.charAt(k - 1);
    }

    private String getNextString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'z') {
                sb.append((char) (str.charAt(i) + 1));
            } else {
                sb.append('a');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new M3304().getNextString("a"));
        System.out.println(new M3304().getNextString("az"));

        System.out.println(new M3304().kthCharacter(5));    // "b"
        System.out.println(new M3304().kthCharacter(10));   // "c"
    }
}
