package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 918. 环形子数组的最大和(中等) 需先学习53题
 * @date 2021-10-27 14:07
 */
public class M918 {

    public int maxSubarraySumCircular(int[] nums) {

        int total = 0;          // 数组的总和
        int maxSum = nums[0];   // 最大子数组和
        int minSum = nums[0];   // 最小子数组和
        int curMax = 0;         // 包含当前元素的最大子数组和
        int curMin = 0;         // 包含当前元素的最小子数组和

        for (int a : nums) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
/*

    最大的环形子数组和 = max(最大子数组和，数组总和-最小子数组和)

 */