package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 844. 比较含退格的字符串
 * @date 2022-03-02 15:18:59
 */
public class M844 {
    /**
     * 我的解法
     */
    public boolean backspaceCompare(String s, String t) {
        String ss = fun(s);
        String tt = fun(t);
        return ss.equals(tt);
    }

    private static String fun(String str) {
        StringBuilder res = new StringBuilder();
        int index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (index == -1) {
                    continue;
                }
                res = res.deleteCharAt(index);
                index--;
            } else {
                res.append(str.charAt(i));
                index++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fun("a#c"));
        System.out.println(fun("b"));
        System.out.println(fun("ab##"));
        System.out.println(fun("c#d#"));
    }
}
