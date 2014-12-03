
//Merge k Sorted Lists 516ms

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月16日15:12:03
 * @url:https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * 1、参考Merge Two Sorted Lists，依次归并，每个节点都至少需要扫描一次，很耗时间。
 * 2、参考地址LeetCode:Merge k Sorted Lists，分析的很详细。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37878255
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

import java.util.ArrayList;

public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int n = lists.size();
        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++) {
                lists.set(i, mergeTwoLists(lists.get(i), lists.get(i + k)));
            }
            n = k;
        }
        return lists.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode point = node;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                point.next = new ListNode(l2.val);
                point = point.next;
                l2 = l2.next;
            } else {
                point.next = new ListNode(l1.val);
                point = point.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            point.next = new ListNode(l1.val);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            point.next = new ListNode(l2.val);
            point = point.next;
            l2 = l2.next;
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
