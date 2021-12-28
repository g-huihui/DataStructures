package top.gongyanhui.datastructures;

import top.gongyanhui.domain.Boy;

/**
 * 构建单向的环形链表思路
 * 1 先创建第一个节点，让first指向该即诶单，并形成环形
 * 2 后面当我们每创建一个新的节点，就把该节点加入到已有的环形链表中即可
 *
 * 遍历环形链表
 * 1 先让一个辅助指针(变量) curBoy 指向first即诶单
 * 2 然后通过一个while循环遍历该环形的链表即可 curBoy.next = first结束
 */
public class CircleSingleLinkedList {

    //创建一个first节点，当前没有节点
    private Boy first = null;

    //添加小孩节点，构建成一个环形的链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确...");
            return;
        }
        //定义辅助指针，帮助构建环形链表
        Boy curBoy = null;
        //使用for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建该节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);   //构成环
                curBoy = first;         //让curBoy = first
            } else {    //说明已经有节点了
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("当前链表为空...");
            return;
        }
        //因为first不能移动，因此需要使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号为" + curBoy.getNo());
            if (curBoy.getNext() == null) {
                //说明小孩已经遍历完
                break;
            }
            curBoy = curBoy.getNext();  //curBoy后移
        }
    }

    /**
     * 报数出队列问题，接收n个人，从第k个人开始报数，报第m个出队列
     * @param startNo   从第几个开始
     * @param countNum  数几下
     * @param nums      最初共有多少小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数有误...");
            return;
        }
        //创建辅助指针
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                //说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动到k处，即k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当前小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        while (true) {
            if (helper == first) {
                //说明圈中只有一个节点
                break;
            }
            //first和helper指针同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //最后first所指就是出圈小孩
            System.out.printf("小孩%d出圈..\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后出圈的小孩是" + first.getNo());
    }
}
