
//Reverse Linked List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日16:57:00
 * @url:https://leetcode.com/problems/reverse-linked-list/
 */

public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        ListNode end = null;
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            q = p.next;
            p.next = end;
            end = p;
            p = q;
        }
        return end;
    }
}