package top.gongyanhui.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Gong Yanhui
 * @description 1089. 复写零
 * @date 2022-06-17 09:03:17
 */
public class M1089 {

    public static void main(String[] args) {
        M1089 m = new M1089();

        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};  // [1,0,0,2,3,0,0,4]
        m.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        m.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{0, 1, 7, 6, 0, 2, 0, 7};    // [0,0,1,7,6,0,0,2]
        m.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{8, 4, 5, 0, 0, 0, 0, 7};    // [8,4,5,0,0,0,0,0]
        m.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 解答有问题(不使用额外的空间)
     */
    public void duplicateZeros(int[] arr) {
        int count = 0;  //记录0的个数 即偏移量
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = arr.length - 1; i - count >= 0; i--) {
            int tmp = arr[i - count];
            if (tmp == 0) {
                arr[i] = 0;
                if (i != 0) {
                    i--;
                    arr[i] = 0;
                }
                count--;
                continue;
            }
            arr[i] = tmp;
        }
    }

    public void duplicateZeros1(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        while (stack.size() != arr.length) {
            int tmp = arr[index];
            index++;
            stack.push(tmp);
            if (stack.size() == arr.length) {
                break;
            }
            if (tmp == 0) {
                stack.push(tmp);
            }
        }
        index = arr.length - 1;
        while (!stack.isEmpty()) {
            arr[index] = stack.pop();
            index--;
        }
    }
}
