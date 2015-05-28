
//Partition List

import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:17:02
 * @url:https://leetcode.com/problems/partition-list/
 */

public class Partition_List {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode minNode = new ListNode(0);
        ListNode p = minNode;
        ListNode maxNode = new ListNode(0);
        ListNode q = maxNode;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = maxNode.next;
        return minNode.next;
    }
}