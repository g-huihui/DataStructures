package top.gongyanhui.datastructures;

public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造函数
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //是否栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //是否栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满.不能入栈...");
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空.无法出栈...");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况 [遍历栈] 遍历时 需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空.没有数据...");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }

    //peek方法 可以返回当前栈顶的值 但不是真正的pop()
    public int peek() {
        return stack[top];
    }
}
