package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 2210. 统计数组中峰和谷的数量
 * @Date: 2025-07-27 17:56
 */

public class M2210 {

    // 我自己的解法
    public int countHillValley(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int nextIndex = i + 1;
            while (nextIndex < nums.length && nums[nextIndex] == nums[nextIndex - 1]) {
                nextIndex++;
            }
            if (nextIndex == nums.length) {
                break;
            }
            if ((nums[i - 1] < nums[i] && nums[nextIndex] < nums[i]) ||
                    (nums[i - 1] > nums[i] && nums[nextIndex] > nums[i])) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new M2210().countHillValley(new int[]{2, 4, 1, 1, 6, 5})); // 3
        System.out.println(new M2210().countHillValley(new int[]{6, 6, 5, 5, 4, 1})); // 0
    }
}
