package top.gongyanhui.datastructures;

public class ArrayQueue {

    private int maxSize;
    private int front;      //指向队头的数据
    private int rear;       //指向队尾的数据
    private int[] arr;      //存储数据

    //构造方法
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[arrMaxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //入队列
    public void addQueue(int n) {
        if (isFull()) {
            //通过抛出异常
            throw new RuntimeException("队列已满 无法入队列...");
        }
        arr[++rear] = n;
    }

    //出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空 无法出队列...");
        }
        return arr[++front];
    }

    //显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("没有数据...");
        }
        for (int i = front+1; i <= rear; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }

    //显示队列的头数据 (不取出) --- peek
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("没有数据...");
        }
        return arr[front + 1];
    }
}
