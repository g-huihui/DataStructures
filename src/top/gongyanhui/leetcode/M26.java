package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 26. 删除有序数组中的重复项
 * @date 2022-07-11 23:12:24
 */
public class M26 {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
                count++;
            }
        }
        return count;
    }
}
