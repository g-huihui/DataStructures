package top.gongyanhui.search;

/**
 * @author Gong Yanhui
 * @description TODO
 * @date 2022-02-01 17:21
 * Github: fucking-algorithm/算法思维系列/二分查找详解.md
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[] {10, 11, 22, 33, 44, 55, 66, 77, 88, 99};
        int target = 99;

        System.out.println(find(arr, 0, arr.length - 1, target));
    }

    /**
     * @return 返回对应的索引下标 未找到返回-1
     * 1、为什么 while 循环的条件中是 <=，而不是 < ？
     *  答：因为初始化 right 的赋值是 nums.length - 1，即最后一个元素的索引，而不是 nums.length。
     */
    public static int find(int[] arr, int left, int right, int target) {
        while (left <= right) {
            //int mid = (left + right) / 2;
            int mid = left + (right - left) / 2; //相比上一种写法，结果完全相同，但是有效防止了 left 和 right 太大直接相加导致溢出

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) { //不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节。
                right = mid - 1;
            }
        }
        return -1;  //未找到
    }
}
