
//Reverse Linked List II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月19日10:29:48
 * @url:https://leetcode.com/problems/reverse-linked-list-ii/
 */

public class Reverse_Linked_List_II {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode aHead = new ListNode(0);
        aHead.next = head;
        ListNode first = aHead;
        int k = 1;
        while (first != null && k < m) {
            k++;
            first = first.next;
        }
        ListNode mid = first.next;
        ListNode second = mid;
        first.next = null;
        while (second != null && k < n) {
            k++;
            second = second.next;
        }
        ListNode right = second.next;
        second.next = null;
        ListNode p = mid;
        ListNode q = null;
        ListNode end = right;
        while (p != null) {
            q = p.next;
            p.next = end;
            end = p;
            p = q;
        }
        first.next = end;
        return aHead.next;
    }
}