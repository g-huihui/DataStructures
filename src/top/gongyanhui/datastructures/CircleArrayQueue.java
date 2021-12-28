package top.gongyanhui.datastructures;

//环形队列
public class CircleArrayQueue {

    private int maxSize;
    private int front;  //front指向队头第一个元素    arr[front]就是第一个元素
    private int rear;   //rear指向队尾的最后一个元素的后一个位置 约定: 希望空一个空间，即会损失一个空间
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //进队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满...");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空..无法取数据...");
        }
        //先取值 操作完队列 之后在返回数据
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //打印队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列中没有数据...");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println("arr[" + i%maxSize + "]=" + arr[i%maxSize]);
        }
    }

    //返回队列中有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("没有数据...");
        }
        return arr[front];
    }
}
