package top.gongyanhui.leetcode;

import java.util.*;

/**
 * @author Gong Yanhui
 * @description 398. 随机数索引
 * @date 2022-04-25 17:38:07
 */
public class M398 {

    Map<Integer, List<Integer>> map;
    Random random;

    public M398(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list == null) {
            return -1;
        }
        return list.get(random.nextInt(list.size()));
    }
}