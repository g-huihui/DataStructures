package top.gongyanhui.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Taurus
 * @Description: 3487. 删除后的最大子数组元素和
 * @Date: 2025-07-25 22:25
 */

class M3487 {

    // 使用流式数组去重
    public int maxSum1(int[] nums) {
        nums = java.util.Arrays.stream(nums).distinct().toArray();
        int total = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > maxNum) { // 记录数组最大值
                maxNum = num;
            }
            if (num < 0) {
                continue;   // 跳过负数 保证最大子数组和
            }
            total += num;
        }
        if (total == 0) {   // 说明此时数组全为负数 返回数组最大值即可
            return maxNum;
        }

        return total;
    }

    // 官方解法
    public int maxSum2(int[] nums) {
        Set<Integer> positiveNumSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumSet.add(num);
            }
        }

        // 如果数组中没有正数 返回数组中最大值即可
        if (positiveNumSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }

        return positiveNumSet.stream().mapToInt(Integer::intValue).sum();
    }

    // 灵茶山艾府 解法
    public int maxSum3(int[] nums) {
        Set<Integer> set = new HashSet<>(); // 只存储正数
        int total = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < 0) {
                maxNum = Math.max(num, maxNum); // 记录最大的负数
            } else if (set.add(num)) {  // 如果添加成功 说明没有重复
                total+=num; // 将去重后的正数累加
            }
        }

        return set.isEmpty() ? maxNum : total;
    }
}
