package top.gongyanhui.leetcode;

/**
 * @Author: Taurus
 * @Description: 3477. 水果成篮 II
 * @Date: 2025-08-09 15:10
 */

public class M3477 {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int[] used = new int[fruits.length];
        int resCound = 0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    if (used[j] == 0) {
                        used[j]++;
                        break;
                    } else {
                        if (j == baskets.length - 1) {
                            resCound++;
                        }
                    }
                } else {
                    if (j == baskets.length - 1) {
                        resCound++;
                    }
                }
            }
        }
        return resCound;
    }

    public static void main(String[] args) {
        M3477 m = new M3477();
        System.out.println(m.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));  // 1
    }
}
