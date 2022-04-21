package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 55. 跳跃游戏(中等)
 * @date 2021-10-24 14:30
 */
public class M55 {
    /**
     * 我自己的解法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= index) {
                index = i;
            }
        }
        return index == 0;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,1,4};   //true
        int[] arr2 = new int[]{3,2,1,0,4};   //false
        System.out.println(canJump(arr1));
        System.out.println(canJump(arr2));
    }
}
