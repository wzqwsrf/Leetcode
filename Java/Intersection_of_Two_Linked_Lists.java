
//Intersection of Two Linked Lists 303ms

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:      a1 → a2
 *               ↘
 *               c1 → c2 → c3
 *               ↗
 * B: b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * Credits:
 * Special thanks to @stellari for adding this problem and creating all test cases.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月13日16:36:22
 * @url:https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * 链表的公共节点
 * 具体参考http://blog.csdn.net/u013027996/article/details/43795441
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Intersection_of_Two_Linked_Lists {
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
