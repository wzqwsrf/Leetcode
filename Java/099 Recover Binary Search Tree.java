
// Recover Binary Search Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:25:39
 * @url:https://leetcode.com/problems/recover-binary-search-tree/
 */

public class Solution {

    private TreeNode first;
    private TreeNode sec;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        first = null;
        sec = null;
        pre = null;
        findError(root);
        if (first != null && sec != null) {
            int temp = sec.val;
            sec.val = first.val;
            first.val = temp;
        }
    }

    private void findError(TreeNode root) {
        if (root == null) {
            return;
        }
        findError(root.left);
        if (pre != null && root.val < pre.val) {
            if (first == null) {
                first = pre;
                sec = root;
            } else {
                sec = root;
                return;
            }
        }
        pre = root;
        findError(root.right);
    }
}