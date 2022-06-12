package top.gongyanhui.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gong Yanhui
 * @description 890. 查找和替换模式
 * @date 2022-06-12 10:55:03
 */
public class M890 {

    public static void main(String[] args) {
        System.out.println(new M890().findAndReplacePattern(new String[] {"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isMapping(word, pattern) && isMapping(pattern, word)) { //注意
                res.add(word);
            }
        }
        return res;
    }

    public boolean isMapping(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            char y = pattern.charAt(i);
            if (map.containsKey(x) && map.get(x) != y) {
                return false;
            } else {
                map.put(x, y);
            }
        }
        return true;
    }

    /**
     * leetcode解法必须两个同时为true才匹配
     * match(word, pattern) && match(pattern, word)
     */
    public boolean match(String word, String pattern) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < word.length(); ++i) {
            char x = word.charAt(i), y = pattern.charAt(i);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (map.get(x) != y) { // word 中的同一字母必须映射到 pattern 中的同一字母上
                return false;
            }
        }
        return true;
    }
}
