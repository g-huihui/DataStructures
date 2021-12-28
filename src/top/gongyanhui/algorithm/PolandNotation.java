package top.gongyanhui.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算最后的值
 *
 * 前缀表达式(波兰表达式)     (3+4)*5-6  --->  - * + 3 4 5 6
 * 后缀表达式(逆波兰表达式)    (3+4)*5-6  --->  3 4 + 5 * 6 -
 */
public class PolandNotation {

    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        //先将字符串放到ArrayList中
        //将ArrayList传递给一个方法，配合栈计算
        List<String> listString = getListString(suffixExpression);
        System.out.println(listString);
        //运算结果
        System.out.println("运算结果=" + calculate(listString));

        System.out.println("--------------------------------------------------------------------------");
        String str = "(3+4)*5-6";
        //将中缀表达式转为List
        List<String> infixExpression = toInfixExpressionList(str);
        //将中缀表达式List转为后缀表达式
        List<String> suffixExpression1 = parseSuffixExpressionList(infixExpression);
        System.out.println("运算结果=" + calculate(suffixExpression1));
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> list) {
        //创建栈 只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) { //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                //不是数 pop出两个数运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result;
                if (item.equals("+")) {
                    result = num1 + num2;
                } else if (item.equals("-")) {
                    result = num1 - num2;
                } else if (item.equals("*")) {
                    result = num1 * num2;
                } else if (item.equals("/")) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误...");
                }
                stack.push(result + "");    //将结果压入栈 转为字符串
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }

    //将中缀表达式转为后缀表达式
    //将中缀表达式转为对应的List
    public static List<String> toInfixExpressionList(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;  //指针 用于遍历s表达式
        String str;     //用于多位数的拼接
        char c;         //每遍历到一个字符，就放入c中
        do {
            //如果是一个非数字
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
                list.add(c + "");
                index++;
            } else {
                //如果是一个数 需要考虑多位数
                str = "";   //先置成空
                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
                    str += c;   //拼接
                    index++;
                }
                list.add(str);
            }
        } while (index < s.length());
        return list;
    }

    //将得到的中缀表达式对应的List转为后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> list) {
        //定义两个空间 一个栈 一个ArrayList
        //原本应该两个栈 但由于s2这个栈没有使用pop操作 而且后面还需要逆序输出
        Stack<String> s1 = new Stack<>();   //符号栈
        List<String> s2 = new ArrayList<>();//存储中间结果的s2
        //遍历list
        for (String item : list) {
            //如果是一个数字 加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();   //将 "(" 弹出s1栈 消除小括号
            } else {
                //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出加入到s2中，再次转到与s1中新的栈顶运算符相比较
                while (s1.size() != 0 && priority(s1.peek()) >= priority(item)) {
                    s2.add(s1.pop());
                }
                //还需将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符依次弹出并加入到s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) {
            return 1;
        } else if (oper.equals("+") || oper.equals("-")) {
            return 0;
        } else {
            //假定目前表达式只有+ - * /
            return -1;
        }
    }
}
