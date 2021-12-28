package top.gongyanhui.datastructures;

import top.gongyanhui.domain.Emp;

public class EmpLinkedList {

    //头指针 执行第一个Emp 因此这个链表的head是直接指向Emp
    private Emp head;   //默认为null

    //添加雇员到链表(添加雇员时 id是自增长 即id的分配总是从小到大的 直接加到链表最后即可)
    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员 则使用一个辅助的指针 帮助定位到最后
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        //退出while时 就将emp加入到链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("链表为空...");
            return;
        }
        System.out.println("当前链表信息为~~~~~~");
        Emp curEmp = head;  //辅助执政
        while (true) {
            System.out.println(curEmp);
            if (curEmp.next == null) {
                //说明已经到最后节点
                break;
            }
            curEmp = curEmp.next;
        }
    }

    //根据ID查找雇员 如果查找到返回Emp 如果没有找到返回null
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空...");
            return null;
        }
        Emp curEmp = head;  //辅助指针
        while (true) {
            if (curEmp.id == id) {  //找到了
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}
