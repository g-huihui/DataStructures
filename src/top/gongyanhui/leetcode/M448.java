package top.gongyanhui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gong Yanhui
 * @description 448. 找到所有数组中消失的数字
 * @date 2022-04-26 17:31:27
 */
public class M448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 该数字对应的索引下标
            int index = nums[i] - 1;
            // 让对应索引下标的数字加n
            nums[index % n] += n;
        }

        //最后遍历只要不大于n的数字就是没有出现过的
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));
    }
}

// [4,3,2,7,8,2,3,1] ===> [1,2,2,3,3,4,7,8]
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。