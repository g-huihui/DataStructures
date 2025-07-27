package top.gongyanhui.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Taurus
 * @Description: 1394. 找出数组中的幸运数
 * @Date: 2025-07-27 18:33
 */

public class M1394 {

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (key.equals(value) && key > res) {
                res = entry.getKey();
            }
        }

        return res;
    }
}
