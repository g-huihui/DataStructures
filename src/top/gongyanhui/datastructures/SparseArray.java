package top.gongyanhui.datastructures;

//稀疏数组与二维数组的转换
public class SparseArray {
    public static void main(String[] args) {

        int m = 10; //行
        int n = 11; //列

        //创建二维数组
        int[][] chessArr1 = new int[m][n];

        //初始化二维数组的值 --- (0没有棋子 1黑子 2蓝子)
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][5] = 1;

        //输出二维数组
        System.out.println("原始的二维数组为:");
        for (int[] col : chessArr1) {
            for (int i : col) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        //遍历二维数组 记录有效数字个数
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chessArr1[i][j] != 0) sum++;
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];

        //给稀疏数组赋值 遍历
        sparseArr[0][0] = m;
        sparseArr[0][1] = n;
        sparseArr[0][2] = sum;
        int count = 0;  //记录是第几个非0数据
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }



        //将稀疏数组转换为二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //读取稀疏数组中的数据 写入二维数组(从第二行开始)
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出新的二维数组
        System.out.println();
        System.out.println("将稀疏数组转换为二维数组之后的新数组~~~~~");
        for (int[] col : chessArr2) {
            for (int i : col) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
