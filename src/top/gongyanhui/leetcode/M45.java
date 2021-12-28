package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 45. 跳跃游戏 II(中等)
 * @date 2021-10-26 16:55
 */
public class M45 {

    /**
     * 方法一：反向查找出发位置
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int count = 0;
        int index = nums.length - 1;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if ((nums[i] + i) >= index) {
                    index = i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 方法二：正向查找可到达的最大位置
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int count = 0;
        int maxIndex = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, nums[i] + i);
            if (i == end) { //说明已经到达边界
                end = maxIndex;
                count++;
            }
        }
        return count;
    }
}
