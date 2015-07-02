
// Remove Duplicates from Sorted List II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:57:36
 * @url:https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode point = node;
        int start = head.val;
        head = head.next;
        if (head == null) {
            return new ListNode(start);
        }
        int twice = 1;
        while (head != null) {
            if (head.val != start) {
                if (twice == 1) {
                    point.next = new ListNode(start);
                    point = point.next;
                } else {
                    twice = 1;
                }
                if (head.next == null) {
                    point.next = new ListNode(head.val);
                    break;
                }
                start = head.val;
            } else {
                twice++;
            }
            head = head.next;
        }
        return node.next;
    }
}