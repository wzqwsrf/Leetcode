
// Delete Node in a Linked List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-15 15:14:25
 * @url:https://leetcode.com/problems/delete-node-in-a-linked-list/
 */

public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */