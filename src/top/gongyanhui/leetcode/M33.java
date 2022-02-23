package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 33. 搜索旋转排序数组
 * @date 2022-02-23 13:21:56
 */
public class M33 {
    /**
     * 需要保证时间负责度为O(logn) 所以不能直接对数组进行线性查找，需要进行二分查找
     * @return 对应的索引下标
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断哪一段有序
            if (nums[0] <= nums[mid]) { // 左段数组是有序的
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {    //右段数组是有序的
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 5, 6, 7, 8, 9, 0, 1, 2};
        System.out.println(search(nums, 3));
    }
}
