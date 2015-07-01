
// Reverse Nodes in k-Group

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:19:26
 * @url:https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class Solution {

    public ListNode curNode;

    public ListNode reverseKGroup(ListNode head, int k) {
        curNode = head;
        ListNode node = new ListNode(0);
        ListNode p = node;
        boolean flag = true;
        while (curNode != null) {
            ListNode kGroup = reverseK(k);
            if (flag) {
                flag = false;
                p.next = kGroup;
            } else {
                int count = 0;
                while (count < k) {
                    p = p.next;
                    count++;
                }
                p.next = kGroup;
            }
        }
        return node.next;
    }

    public ListNode reverseK(int k) {
        ListNode node = new ListNode(0);
        node.next = curNode;
        ListNode p = curNode;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
            if (count >= k) {
                break;
            }
        }
        if (p == null && count < k) {
            curNode = null;
            return node.next;
        }
        count = 0;
        ListNode q = null;
        ListNode end = null;
        while (count < k) {
            q = curNode;
            curNode = curNode.next;
            q.next = end;
            end = q;
            count++;
        }
        return end;
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