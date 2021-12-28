package top.gongyanhui.algorithm.recursion;

/**
 * 八皇后问题:
 *  1 第一个皇后先放到第一行第一列
 *  2 第二个皇后放到第二行第一列，然后判断是否OK，如果不OK，继续放在第二列、第三列，依次把所有列都放完，找到一个合适的位置
 *  3 当最终得到一个正确解时，在栈回退到上一个栈时，就会孔子学会回溯，即将第一个皇后放到第一列的所有正确解，全部得到
 *  4 然后回头继续，第一个皇后放到第二列，后面继续循环执行1 2 3步骤
 *
 *  一共一万五千多次判断 可以用贪心算法优化
 */
public class Queen8 {

    private int max = 8;
    private int[] arr = new int[max];

    //定义一个全局count
    int count = 0;
    int judgeCount = 0;

    //可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 查看当前放置第n个皇后，就会检测皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //第一个判断同列冲突
            //第二个判断第n个皇后是否和第i个皇后处在
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    //(核心方法) 放置第n个皇后
    private void check(int n) {
        if (n == max) {
            //n=8其实第8个皇后就已经放置好了
            print();
            return;
        }
        //依次放入皇后 并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n放到该行的第1列开始
            arr[n] = i;
            //判断当前位置第n个皇后放到第i列时，是否冲突
            if (judge(n)) {
                //不冲突
                //接着方第n+1个皇后 即开始递归
                check(n+1);
            }
            //如果冲突就继续执行 arr[n] = i 即将第n个皇后 放置在本行的后一个位置
            //for循环就在后移棋子
        }
    }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("一共有" + queen8.count + "种解法");
        System.out.println("不算对称关系的话只有32种解法");

        System.out.println();
        System.out.println("效率很低");
        System.out.println("一共使用judge判断了" + queen8.judgeCount + "次");
    }
}
