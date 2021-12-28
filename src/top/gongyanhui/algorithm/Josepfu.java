package top.gongyanhui.algorithm;

import top.gongyanhui.datastructures.CircleSingleLinkedList;

/**
 * 约瑟夫环问题 (单向环形链表实现)
 * 设置编号为1，2，3...n的n个人围坐一圈，约定编号为k的人从1开始报数，数到m的那个人出列，他的下一个用开始从1开始报数，
 * 数到m的那个人又出列，以此类推，直到所有人出列位置，由此产生一个出队的编号序列。
 *
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csl = new CircleSingleLinkedList();

        //小孩数量
        int num = 13;

        //环形队列中小孩设置数量
        csl.addBoy(num);

        csl.countBoy(3, 2, num);
        //详细算法步骤在CircleSingleLinkedList中的countBoy方法
    }
}
