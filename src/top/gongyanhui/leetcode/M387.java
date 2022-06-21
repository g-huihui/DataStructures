package top.gongyanhui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gong Yanhui
 * @description 387. 字符串中的第一个唯一字符
 * @date 2022-06-21 20:58:20
 */
public class M387 {

    public static void main(String[] args) {
        M387 m = new M387();
        System.out.println(m.firstUniqChar("leetcode"));        // 0
        System.out.println(m.firstUniqChar("loveleetcode"));    // 2
        System.out.println(m.firstUniqChar("aabb"));            // -1
        System.out.println(m.firstUniqChar("aadadaad"));        // 0
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
