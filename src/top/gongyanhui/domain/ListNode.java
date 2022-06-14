package top.gongyanhui.domain;

/**
 * @author Gong Yanhui
 * @description 链表的节点
 * @date 2022-06-14 17:37:44
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {};
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        ListNode cur = next;
        StringBuilder res = new StringBuilder();
        res.append(val).append(", ");
        while (cur != null) {
            res.append(cur.val).append(", ");
            if (cur.next != null) {
                cur = cur.next;
            } else {
                break;
            }
        }
        return res.toString();
    }
}
