
// Construct Binary Tree from Inorder and Postorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月02日17:04:02
 * @url:https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class Solution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        int len1 = inorder.length - 1;
        int len2 = postorder.length - 1;
        if (len1 != len2) {
            return null;
        }
        return dfs(inorder, postorder, 0, len1, len2);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int low,
                         int high, int index) {
        if (low > high) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[index]);
        if (low == high) {
            return node;
        }
        int pos = searchInsert(inorder, postorder[index], low, high);
        node.left = dfs(inorder, postorder, low, pos - 1, index - 1 - (high - pos));
        node.right = dfs(inorder, postorder, pos + 1, high, index - 1);
        return node;
    }

    private int searchInsert(int[] array, int t, int low, int high) {
        int pos = 0;
        for (int i = low; i <= high; i++) {
            if (array[i] == t) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}