package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description TODO 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date 2022-02-22 16:15:42
 */
public class M34 {

    /**
     * 常规解法: 二分查到完后 在向两边进行线性查找 但时间复杂度不符合 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 这里通过线性查找搜索
                int l = mid, r = mid;
                for (; l >= 0; l--) {
                    if (nums[l] != target) {
                        break;
                    }
                }
                for (; r < nums.length; r++) {
                    if (nums[r] != target) {
                        break;
                    }
                }
                result[0] = l + 1;
                result[1] = r - 1;
                return result;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return result;
    }

    /**
     * 标准写法 O(logn)
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        if (nums.length < 1) {
            return res;
        }
        res[0] = left_bound(nums, target);
        if (res[0] == -1) {
            return res;
        }
        res[1] = right_bound(nums, target);
        return res;
    }
    private static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 不返回 锁定左边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
    private static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 不返回 锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 2};

        int[] res = searchRange(nums, 3);
        System.out.println("[" + res[0] + "," + res[1] + "]");
    }
}
