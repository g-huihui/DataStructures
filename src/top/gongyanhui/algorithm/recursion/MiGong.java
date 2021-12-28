package top.gongyanhui.algorithm.recursion;

/**
 * 递归:
 *  1 当程序执行到一个方法时，就会开辟一个新的受保护的独立空间(栈)
 *  2 方法的局部变量是独立的，不会相互影响
 *  3 如果方法中使用引用类型变量，就会共享该引用类型的数据
 *  4 递归必须向退出递归的条件逼近，否则就是无限递归
 */
public class MiGong {
    public static void main(String[] args) {
        //向创建一个二维数组 模拟迷宫(地图)
        int[][] map = new int[8][7];
        //使用 1表示墙
        //先把上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = map[3][2] = 1;
        //设置死路
        //map[3][3] = map[3][4] = map[3][5] = 1;

        //输出地图
        System.out.println("当前地图~~~~~~");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //开始走迷宫
        boolean is = setWay(map, 1, 1);
        if (is) {   //找到出路了
            System.out.println("迷宫出路地图~~~~~~");
        } else {    //没有出路
            System.out.println("迷宫没有出路地图~~~~~~");
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * 约定:
     *  从P(i,j)开始，如果能到map[6][5]位置，则说明通路找到；当map[i][j]为0表示该点还没有走过，为2表示通路可以走，
     *  为3表示该点已经走过但是走不通
     *  在走迷宫时，需要确定一个策略: 下->右->上->左  如果该点走不通再回溯
     * @param map   地图
     * @param i     从哪个位置开始找
     * @param j
     * @return      如果找到通路就返回true 否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            //通路已经找到
            return true;
        } else if (map[i][j] == 0) {
            //如果当前这个点还没有走过
            map[i][j] = 2;  //假设该点可以走通
            if (setWay(map, i+1, j)) {
                //向下走
                return true;
            } else if (setWay(map, i, j+1)) {
                //向右走
                return true;
            } else if (setWay(map, i-1, j)) {
                //向上走
                return true;
            } else if (setWay(map, i, j-1)) {
                //向左走
                return true;
            } else {
                //说明该点走不通，是死路
                map[i][j] = 3;
                return false;
            }
        } else {
            //map[i][j] != 0 则可能为1 2 3 都不用再走了
            return false;
        }
    }
}
