
// Intersection of Two Linked Lists

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月13日16:36:22
 * @url:https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * 链表的公共节点
 * 具体参考http://blog.csdn.net/u013027996/article/details/43795441
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        ListNode p = headA;
        while (p != null) {
            p = p.next;
            len1++;
        }
        int len2 = 0;
        p = headB;
        while (p != null) {
            p = p.next;
            len2++;
        }
        if (len1 > len2) {
            int k = 0;
            while (k < (len1 - len2)) {
                headA = headA.next;
                k++;
            }
        }
        if (len2 > len1) {
            int k = 0;
            while (k < (len2 - len1)) {
                headB = headB.next;
                k++;
            }
        }
        p = headA;
        ListNode q = headB;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
