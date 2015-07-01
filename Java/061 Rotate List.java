
// Rotate List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月12日17:57:41
 * @url:https://leetcode.com/problems/rotate-list/
 */

public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        n %= len;
        if (n == len) {
            return head;
        }
        p = head;
        ListNode node1 = new ListNode(0);
        ListNode q = node1;
        int k = 0;
        while (k < (len - n)) {
            q.next = new ListNode(p.val);
            q = q.next;
            p = p.next;
            k++;
        }
        ListNode node2 = new ListNode(0);
        q = node2;
        while (p != null) {
            q.next = new ListNode(p.val);
            q = q.next;
            p = p.next;
        }
        q.next = node1.next;
        return node2.next;
    }
}

