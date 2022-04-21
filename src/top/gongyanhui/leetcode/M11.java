package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 11. 盛最多水的容器
 * @date 2022-03-02 15:44:28
 */
public class M11 {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
