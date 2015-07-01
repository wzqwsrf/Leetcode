
// Linked List Cycle II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:19:15
 * @url:https://leetcode.com/problems/linked-list-cycle-ii/
 */

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        boolean flag = false;
        while (p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q) {
                flag = true;
                break;
            }
        }
        if (flag) {
            q = head;
            while (p != q) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
        return null;
    }
}