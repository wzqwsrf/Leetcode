
// Swap Nodes in Pairs

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:17:37
 * @url:https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode curNode = head;
        ListNode preNode = node;
        while (curNode != null && curNode.next != null) {
            ListNode tempNode = curNode.next.next;
            curNode.next.next = curNode;
            preNode.next = curNode.next;
            if (tempNode != null && tempNode.next != null) {
                curNode.next = tempNode.next;
            } else {
                curNode.next = tempNode;
            }
            preNode = curNode;
            curNode = tempNode;
        }
        return node.next;
    }
}

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