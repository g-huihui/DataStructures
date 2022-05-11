package top.gongyanhui.leetcode;

import top.gongyanhui.domain.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gong Yanhui
 * @description 297. 二叉树的序列化与反序列化
 * @date 2022-05-11 11:57:53
 */
public class M297 {

    // Encodes a tree to a single string. 使用DFS深度优先搜索
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    public String reserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null ";
        } else {
            str += (root.getVal() + " ");
            str = reserialize(root.getLeft(), str);
            str = reserialize(root.getRight(), str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] numsArray = data.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(numsArray));
        return redeserialize(list);
    }

    public TreeNode redeserialize(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.setLeft(redeserialize(list));
        root.setRight(redeserialize(list));
        return root;
    }

    public static void main(String[] args) {
        M297 m = new M297();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.setLeft(t2);
        t1.setRight(t3);
        t3.setLeft(t4);
        t3.setRight(t5);
        System.out.println(m.serialize(t1));
        //System.out.println(m.deserialize(m.serialize(t1)));
    }
}
