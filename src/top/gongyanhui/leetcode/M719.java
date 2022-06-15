package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * @author Gong Yanhui
 * @description 719. 找出第 K 小的数对距离
 * @date 2022-06-15 10:49:48
 */
public class M719 {

    public static void main(String[] args) {

        M719 m = new M719();
        //System.out.println(m.fun(7));
        System.out.println(m.smallestDistancePair(new int[] {1, 6, 1}, 3));
    }

    /**
     * 我的方法超内存了...
     */
    public int smallestDistancePair1(int[] nums, int k) {

        int[] arr = new int[fun(nums.length)];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                arr[index] = Math.abs(nums[i] - nums[j]);
                index++;
            }
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public int fun(int n) {
        if (n == 1 || n == 0) {
            return 0;
        }
        return fun(n - 1) + (n - 1);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int i = binarySearch(nums, j, nums[j] - mid);
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch(int[] nums, int end, int target) {
        int left = 0, right = end;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
