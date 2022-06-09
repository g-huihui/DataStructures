package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 最长回文子串
 * @date 2022-06-06 17:17:13
 */
public class M5 {
    public static void main(String[] args) {
        M5 m = new M5();
        System.out.println(m.longestPalindrome("babad"));   // bab
        System.out.println(m.longestPalindrome("cbbd"));    // bb
        System.out.println(m.longestPalindrome("ac"));      // a

        System.out.println(m.longestPalindrome("cbcabba"));      // a
    }

    /**
     * 暴力解法 时间复杂度O(n^3)
     * @return 最长回文字符串
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        String res = "";
        // 确定开始位置和结束位置 i j
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + res.length(); j < s.length(); j++) {
                String tmp = s.substring(i, j + 1);
                if (isPalindrome(tmp) && tmp.length() > res.length()) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    /**
     * 判断一个字符串是否为回文
     * @return 返回是否
     */
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
