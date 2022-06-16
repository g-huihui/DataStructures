package top.gongyanhui.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gong Yanhui
 * @description 118. 杨辉三角
 * @date 2022-06-16 17:58:56
 */
public class M118 {

    public static void main(String[] args) {
        M118 m = new M118();
        System.out.println(m.generate(5).toString()); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            // ======================R
            for (int j = 1; j < i; j++) {
                List<Integer> pre = res.get(i - 1);
                list.add(pre.get(j) + pre.get(j - 1));
            }
            // ======================
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
