package top.gongyanhui.datastructures;

import top.gongyanhui.domain.Emp;

//管理多条链表
public class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造函数  初始化empLinkedListArray
    public HashTab(int size) {
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //这是不要忘记了初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    public int hashFun(int id) {
        return id % size;
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id 得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表 遍历hash
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //根据输入ID 查找雇员
    public void findEmpById(int id) {
        //使用散列函数确定到哪条链表查找
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            //找到了
            System.out.println(emp);
        } else {
            //没有找到
            System.out.println("没有找到该雇员....");
        }
    }
}
