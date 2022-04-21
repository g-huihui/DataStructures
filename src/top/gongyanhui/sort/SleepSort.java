package top.gongyanhui.sort;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Gong Yanhui
 * @description 网上乱搞的睡眠排序算法
 * @date 2022-04-08 22:05:58
 */
public class SleepSort {

    /**
     * 多线程同时睡眠排序大法
     * @param nums
     */
    public static void sleepSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(nums[index]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nums[index]);
            }).start();
        }
    }

    /**
     * 通过闭锁的方式解决
     * @param nums
     * @param latch 闭锁
     */
    public static void sleepSort(int[] nums, CountDownLatch latch) {
        for (int i = 0; i < nums.length; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    latch.await();
                    Thread.sleep(nums[index]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(nums[index]);
            }).start();
        }
    }

    /**
     * 通过栅栏的方式解决
     * @param nums
     * @param barrier 栅栏
     */
    public static void sleepSort(int[] nums, CyclicBarrier barrier) {
        for (int i = 0; i < nums.length; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    barrier.await();
                    Thread.sleep(nums[index]);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(nums[index]);
            }).start();
        }
    }

    public static void main(String[] args) {
        int[] arr = {75, 3, 2, 33, 4, 14, 6, 1353, 8, 49, 10, 12, 45, 23, 77, 775, 1};
        /**
         * 当数组数量多 有两个数据相差不大而且相隔很远 大的在前小的在后(1和2)
         * 可能会出现时间上的错误顺序
         */
        //sleepSort(arr);

        // 闭锁
//        CountDownLatch latch = new CountDownLatch(1);
//        sleepSort(arr, latch);
//        latch.countDown();

        // 栅栏
        CyclicBarrier barrier = new CyclicBarrier(arr.length);
        sleepSort(arr, barrier);
    }
}

/*
    栅栏类似于闭锁，它能阻塞一组线程直到某个事件发生。
    栅栏与闭锁的关键区别在于，所有的线程必须同时到达栅栏位置，才能继续执行。
    闭锁用于等待事件，而栅栏用于等待其他线程。
 */