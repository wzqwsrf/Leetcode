
//Merge Two Sorted Lists 576ms

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月15日10:27:52
 * @url:https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 归并排序，考察基本功。
 * 赋值的时候可以new一个节点，也可以将一个链表赋值给另外一个，后者相对慢一些。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37810407
 */

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

public class Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode point = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = l2;
                point = point.next;
                l2 = l2.next;
            } else {
                point.next = l1;
                point = point.next;
                l1 = l1.next;
            }
        }
        if (l1 != null) {
            point.next = l1;
        }
        if (l2 != null) {
            point.next = l2;
        }
        return node.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}