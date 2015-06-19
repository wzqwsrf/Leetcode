
// Insertion Sort List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月19日18:16:48
 * @url:https://leetcode.com/problems/insertion-sort-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Insertion_Sort_List {
    public ListNode insertionSortList(ListNode head) {
        ListNode aHead = new ListNode(0);
        aHead.next = null;
        ListNode p = head;
        ListNode q = null;
        while (p != null) {
            q = aHead;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }
            ListNode pNext = p.next;
            ListNode qNext = q.next;
            q.next = p;
            p.next = qNext;
            p = pNext;
        }
        return aHead.next;
    }
}