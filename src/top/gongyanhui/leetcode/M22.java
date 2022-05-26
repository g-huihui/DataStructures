package top.gongyanhui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gong Yanhui
 * @description 22. 括号生成
 * @date 2022-05-26 11:18:34
 */
public class M22 {

    public static void main(String[] args) {
        M22 m = new M22();
        System.out.println(m.generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     *
     * @param open  左括号
     * @param close 右括号
     * @param max   括号对数
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {   //如果左括号没有超过最大括号数
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) { //如果右括号小于左括号数
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
