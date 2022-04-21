package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 53. 最大子序和(简单)
 * @date 2021-10-26 17:47
 */
public class M53 {

    /**
     * 动态规划: 若前一个元素大于0，则将其加到当前元素上
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
