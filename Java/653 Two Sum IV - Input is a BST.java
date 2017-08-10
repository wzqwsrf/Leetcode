
// 653. Two Sum IV - Input is a BST

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-10 12:42:38
 * @url:https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
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
    private List<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        list = new ArrayList<Integer>();
        inOrder(root);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}