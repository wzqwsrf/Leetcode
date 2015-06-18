
//Reorder List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月18日18:49:17
 * @url:https://leetcode.com/problems/reorder-list/
 */


public class Reorder_List {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        ListNode q = null;
        ListNode end = null;
        while (p != null) {
            q = p.next;
            p.next = end;
            end = p;
            p = q;
        }
        slow.next = null;
        while (head != null && end != null) {
            q = head.next;
            head.next = end;
            end = end.next;
            head.next.next = q;
            head = q;
        }
    }
}