package top.gongyanhui.leetcode;

/**
 * @author Gong Yanhui
 * @description 82. 删除排序链表中的重复元素 II
 * @date 2022-02-23 15:26:38
 */
public class M82 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,3,4,4,5};
        ListNode head = new ListNode(nums[0]);

        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }

        //System.out.println(head);
        System.out.println(deleteDuplicates(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
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