package top.gongyanhui.algorithm;

import java.util.Stack;

//使用栈计算表达式结果 ---- [中缀表达式]
public class Calculator {

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    //数字越大，则优先级越高
    static int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            //假定目前表达式只有+ - * /
            return -1;
        }
    }

    //判断是不是一个运算符
    static boolean isoper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //写一个计算方法
    static int cal(int num1, int num2, char oper) {
        int result = 0; //用于存放计算的结果
        switch (oper) {
            case '+': result = num2 + num1;
                break;
            case '-': result = num2 - num1;
                break;
            case '*': result = num2 * num1;
                break;
            case '/': result = num2 / num1;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String expression = "3+20*6-2";
        //创建两个栈
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operStack = new Stack<>();

        int index = 0;          //用于扫描表达式的下标
        int num1;               //第一个数字
        int num2;               //第二个数字
        char oper;              //获取的操作符
        int result;             //计算的结果
        char ch = ' ';          //将每次扫描得到的字符保存到ch中
        String keepNum = "";    //用于拼接多位数

        //开始while循环的扫描expression
        while (index < expression.length()) {
            //一次得到expression的每一个字符
            ch = expression.charAt(index);
            //判断ch是什么 然后做相应的处理
            if (isoper(ch)) {   //是运算符
                //判断栈是否为空
                if (!operStack.isEmpty()) { //不为空
                    //判断当前ch 和 栈顶元素的优先级
                    if (priority(ch) <= priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = cal(num1, num2, oper);
                        //把计算的结果入数栈
                        numStack.push(result);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {    //栈为空
                    operStack.push(ch);
                }
            } else {    //是数字 不是运算符
                //该做法只能针对单个数字
                //numStack.push(ch - 48); //注意ch为字符
                /** 分析:
                 *      1 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                 *      2 在处理数，需要向expression的表达式的index后面再看以为，如果是数就进行扫描，如果是符号才入栈
                 *      3 因此需要定义一个变量字符串，用于拼接
                 */
                keepNum += ch;
                //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符 则入栈
                if (index == expression.length() - 1) { //判断是否为最后一位
                    numStack.push(Integer.parseInt(keepNum));
                } else {    //不是最后一位
                    if (isoper(expression.charAt(index + 1))) { //是操作符
                        numStack.push(Integer.parseInt(keepNum));
                    } else {
                        //下一位还是数字
                        keepNum += expression.charAt(index + 1);
                        numStack.push(Integer.parseInt(keepNum));
                        index++;
                    }
                }
                //记的把keepNum清空(重要!!!)
                keepNum = "";
            }
            index++;
        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (!operStack.isEmpty()) {  //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字[结果]
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            result = cal(num1, num2, oper);
            numStack.push(result);  //入栈
        }

        System.out.println("表达式:" + expression + "=" + numStack.pop());
    }
}
