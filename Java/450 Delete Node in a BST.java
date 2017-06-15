
// 450. Delete Node in a BST

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-15 22:54:17
 * @url:https://leetcode.com/problems/delete-node-in-a-bst/#/description
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key == root.val) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode left = findLeft(root.right);
            root.val = left.val;
            root.right = deleteNode(root.right, root.val);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findLeft(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}