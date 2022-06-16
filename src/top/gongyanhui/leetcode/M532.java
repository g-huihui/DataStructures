package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * @author Gong Yanhui
 * @description 532. 数组中的 k-diff 数对
 * @date 2022-06-16 14:20:16
 */
public class M532 {

    public static void main(String[] args) {
        M532 m = new M532();
        System.out.println(m.findPairs(new int[] {3, 1, 4, 1, 5}, 2));  // 2
        System.out.println(m.findPairs(new int[] {1, 2, 3, 4, 5}, 1));  // 4
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int index = 0;  //后指针
        for (int pre = 0; pre < nums.length; pre++) {
            if (pre != 0 && nums[pre] == nums[pre - 1]) {
                continue;
            }
            while (index < nums.length && (nums[index] - nums[pre] < k || index <= pre)) { //后指针向后移动的条件
                index++;    //后指针向后移动
            }
            if (index < nums.length && nums[index] - nums[pre] == k) {
                count++;
            }
        }
        return count;
    }
}
