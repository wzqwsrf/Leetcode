
// Construct Binary Tree from Preorder and Inorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:03:47
 * @url:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len1 = preorder.length - 1;
        int len2 = inorder.length - 1;
        if (len1 != len2) {
            return null;
        }
        return dfs(preorder, inorder, 0, len2, 0);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int low,
                         int high, int index) {
        if (low > high) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index]);
        if (low == high) {
            return node;
        }
        int pos = searchInsert(inorder, preorder[index], low, high);
        node.left = dfs(preorder, inorder, low, pos - 1, index + 1);
        node.right = dfs(preorder, inorder, pos + 1, high, index + pos - low
                + 1);
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