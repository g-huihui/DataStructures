package top.gongyanhui.leetcode;

import java.util.Stack;

/**
 * @author Gong Yanhui
 * @description TODO 20. 有效的括号
 * @date 2022-03-09 17:40:34
 */
public class M20 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                char pop = stack.pop();
                if (isMatch(pop, c)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char pop, char c) {
        if (pop == '(' && c == ')') {
            return true;
        } else if (pop == '[' && c == ']') {
            return true;
        } else if (pop == '{' && c == '}') {
            return true;
        } else {
            return false;
        }
    }
}
