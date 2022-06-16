package top.gongyanhui.leetcode;

import java.util.*;

/**
 * @author Gong Yanhui
 * @description 350. 两个数组的交集 II
 * @date 2022-06-16 16:46:30
 */
public class M350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); //交换数组 节省内存空间
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            if (!map.containsKey(num)) {
                continue;
            }
            int count = map.get(num);
            if (count > 0) {
                res[index] = num;
                index++;
                count--;
                if (count < 1) {
                    map.remove(num);
                } else {
                    map.put(num, count);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
