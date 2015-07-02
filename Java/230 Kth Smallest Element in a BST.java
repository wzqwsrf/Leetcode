
// Kth Smallest Element in a BST

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年07月02日14:08:45
 * @url:https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 中序遍历
 */

public class Solution {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private int count = 0;
    private int kNum = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return kNum;
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        count--;
        if(count == 0){
            kNum = root.val;
            return;
        }
        inOrder(root.right);
    }
}
