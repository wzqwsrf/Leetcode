
// Sort List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月19日18:18:16
 * @url:https://leetcode.com/problems/sort-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Sort_List {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode start, ListNode end) {
        if (start != end) {
            ListNode mid = getPartion(start, end);
            quickSort(start, mid);
            quickSort(mid.next, end);
        }
    }

    private ListNode getPartion(ListNode start, ListNode end) {
        int val = start.val;
        ListNode p = start;
        ListNode q = start.next;
        while (q != end) {
            if (q.val < val) {
                p = p.next;
                swapVal(p, q);
            }
            q = q.next;
        }
        swapVal(p, start);
        return p;
    }

    private void swapVal(ListNode p, ListNode q) {
        int val = p.val;
        p.val = q.val;
        q.val = val;
    }
}