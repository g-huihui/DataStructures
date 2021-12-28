package top.gongyanhui.domain;

public class Boy {
    private int no;
    private Boy next = null;    //指向下一个节点 默认为null

    //构造方法
    public Boy(int no) {
        this.no = no;
    }

    /* Getter and Setter */
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
