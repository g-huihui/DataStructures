package top.gongyanhui.leetcode;

import top.gongyanhui.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Gong Yanhui
 * @description 513. 找树左下角的值
 * @date 2022-06-23 01:27:01
 */
public class M513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.getVal();
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode poll = queue.poll();
                if (poll.getLeft() != null) {
                    queue.offer(poll.getLeft());
                }
                if (poll.getRight() != null) {
                    queue.offer(poll.getRight());
                }
                if (i == 0) {
                    res = poll.getVal();
                }
            }
        }
        return res;
    }
}
