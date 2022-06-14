package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 14. 最长公共前缀
 * @date 2022-06-14 16:26:26
 */
public class M14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[] {""}));
        System.out.println(longestCommonPrefix(new String[] {"", ""}));
        System.out.println(longestCommonPrefix(new String[] {"", "b"}));
        System.out.println(longestCommonPrefix(new String[] {"ab", "a"}));
        System.out.println(longestCommonPrefix(null));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        String str = strs[0];
        for (String s : strs) {
            if (s.length() == 0) {
                return "";
            }
        }
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < strs.length; i++) {
                if (index == str.length() || index == strs[i].length()) {
                    return builder.toString();
                }
                if (strs[i].charAt(index) != str.charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                builder.append(str.charAt(index));
                index++;
            }
        }
        return builder.toString();
    }
}
