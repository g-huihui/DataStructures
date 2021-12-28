package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 740. 删除并获得点数(中等)
 * @date 2021-10-24 13:49
 */
public class M740 {
    /**
     * 理解198题后，基本相同，需要重新构造数组，以元素的值来做下标，下标对应的元素是原来的元素的个数。
     *  举个例子：nums = [2, 2, 3, 3, 3, 4]
     *  构造后：  all  = [0, 0, 2, 3, 1]
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] refactor = new int[max + 1];
        for (int num : nums) {
            refactor[num]++;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = Math.max(dp[0], refactor[1]);
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + refactor[i] * i);
        }
        return dp[max];
    }
}
