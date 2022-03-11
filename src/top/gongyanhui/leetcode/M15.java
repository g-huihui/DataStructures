package top.gongyanhui.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gong Yanhui
 * @description TODO 15. 三数之和
 * @date 2022-03-11 16:46:37
 */
public class M15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 首先需要和上一次枚举的数不相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;    //第三个数的位置 对应的指针初始指向数组的最右端
            int target = -nums[i];      //寻找的目标值
            for (int j = i + 1; j < nums.length - 1; j++) {
                // 需要和上一次枚举的数不相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 保证 j指针 在 k指针 的左边 --- 移动k指针
                while (j < k && (nums[j] + nums[k]) > target) {
                    k--;
                }
                if (j == k) { // 如果指针重合，随着 j 后续的增加
                    break;
                }
                if (nums[j] + nums[k] == target) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[k]);
                    res.add(item);
                }
            }
        }

        return res;
    }
}
