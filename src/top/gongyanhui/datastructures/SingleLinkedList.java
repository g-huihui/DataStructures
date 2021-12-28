package top.gongyanhui.datastructures;

import top.gongyanhui.domain.HeroNode;

import java.util.Stack;

//单链表
public class SingleLinkedList {

    //初始化头节点 头节点不动
    private HeroNode head = new HeroNode(0, "", "");
    //头节点的Get方法
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //找到当前链表的最后节点 将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //辅助节点
        HeroNode temp = head;

        //遍历 找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        //退出while时 temp就指向了链表的最后
        temp.next = heroNode;
    }

    //显示链表
    public void list() {
        //判断是否有数据
        if (head.next == null) {
            System.out.println("当前链表中没有数据...");
            return;
        }
        //头节点不动
        HeroNode temp = head.next;

        while (true) {
            if (temp == null) break;
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //按顺序添加数据
    //首先找到新添加的节点的位置 通过辅助变量指针
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;   //标记添加的编号是否存在 默认为false
        while (true) {
            if (temp.next == null) {    //链表已经到最后
                break;
            }
            if (temp.next.no > heroNode.no) {   //位置找到了 就在temp
                break;
            } else if (temp.next.no == heroNode.no) {
                //已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("编号已经存在...不能加入");
        } else {
            heroNode.next = temp.next;
            temp = heroNode;
        }
    }

    //修改节点信息 根据no编号来修改 即no编号不能改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空...");
            return;
        }
        //根据no编号找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;   //表示是否找到
        while (true) {
            if (temp == null) break;    //已经遍历完链表
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号为" + newHeroNode.no + "的信息");
        }
    }

    //删除 找到需要删除的前一个节点 比较时 是temp.next.no和需要删除的比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false;   //表示是否找到删除节点
        while (true) {
            if (temp.next == null) {    //已经在最后
                break;
            }
            if (temp.next.no == no) {   //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //找到了
            temp.next = temp.next.next;
        } else {
            System.out.println("没有找到该数据...");
        }
    }

    //获取单链表的节点数 (如果带头节点 不统计头节点)
    static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0; //计数器
        //定义一个辅助变量  ---------  从该变量的head.next中就可以看出没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表的倒数第K个节点
    //思路: 接收头节点和index(表示倒数第index个) 遍历链表得到链表总长度(可以调用getLength方法) 得到size后从链表第一个开始遍历(size-index)个
    static HeroNode findLastIndexNode(HeroNode head, int index) {
        //如果链表为空就返回null ---- 没有找到
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        //第二次遍历size-index位置 就是倒数第K个节点 先做一个index校验
        if (index <= 0 || index > size) return null;
        //定义辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size-index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //单链表的反转
    //定义一个节点reverseHead 从头到尾遍历原来的链表 每遍历一遍 将其却出放入到reverseHead链表的最前端
    static void reverseList(HeroNode head) {
        //如果当前链表为空，或者当前链表中只有一个节点 无需反转直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助变量(指针) 帮助遍历原来的节点
        HeroNode cur = head.next;
        //定义当前节点[cur]的下一个节点
        HeroNode next = null;
        //定义反转的节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (cur != null) {
            next = cur.next;                //先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;    //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;         //将cur连接到新的链表上
            cur = next;                     //cur后移
        }
        //将head.next指向reverseHead.next 实现单链表的反转
        head.next = reverseHead.next;
    }

    //从尾到头打印单链表
    //利用栈这个数据结构 将各个节点压入栈中 利用栈的先进先出的特点 就实现了逆序打印的结果
    static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建栈 将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中所有的节点进行打印pop出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}
