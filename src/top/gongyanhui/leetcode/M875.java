package top.gongyanhui.leetcode;

import java.util.Arrays;

/**
 * @author Gong Yanhui
 * @description 875. 爱吃香蕉的珂珂
 * @date 2022-06-07 10:48:04
 */
public class M875 {
    public static void main(String[] args) {
        M875 m = new M875();
        System.out.println(m.minEatingSpeed(new int[] {3,6,7,11}, 8));      // 4
        System.out.println(m.minEatingSpeed(new int[] {30,11,23,4,20}, 5)); // 30
        System.out.println(m.minEatingSpeed(new int[] {30,11,23,4,20}, 6)); // 23
    }

    public int minEatingSpeed(int[] piles, int h) {
        // 先排个序
        Arrays.sort(piles);

        // 获取二分的上界和下界
        int low = 1;                            // 最小速度不能小于1
        int high = piles[piles.length - 1];     // 最大速度不能大于最大香蕉数

        int res_speed = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            int time = getTime(piles, speed);
            if (time <= h) {
                res_speed = speed;          // 先保留合适的速度
                //high = speed - 1;         // 尝试把速度-1 获取最小的时间 (错误 不能-1)
                high = speed;               // 改变上界的值 逐渐缩小速度
            } else {    // 超时间 速度太慢 速度+1
                low = speed + 1;
            }
        }
        return res_speed;
    }

    /**
     * 获取总时间
     * @param piles 当前数组的香蕉个数
     * @param speed 当前吃香蕉的速度
     * @return 总时间
     */
    private int getTime(int[] piles, int speed) {
        int totalTime = 0;
        for (int pile : piles) {
            int time = (pile + speed - 1) / speed;
            totalTime += time;
        }
        return totalTime;
    }
}
