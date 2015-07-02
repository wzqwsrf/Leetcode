
// Convert Sorted List to Binary Search Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:05:47
 * @url:https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return createBSTree(head, null);
    }

    private TreeNode createBSTree(ListNode start, ListNode end) {
        if (start == end) {
            return null;
        }
        ListNode fastNode = start;
        ListNode slowNode = start;
        while (fastNode != end && fastNode.next != end) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        TreeNode root = new TreeNode(slowNode.val);
        root.left = createBSTree(start, slowNode);
        root.right = createBSTree(slowNode.next, end);
        return root;
    }
}