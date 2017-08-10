
// 654. Maximum Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-10 12:40:25
 * @url:https://leetcode.com/problems/maximum-binary-tree/description/
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        return dfsConstructTree(nums, 0, len - 1);
    }

    private TreeNode dfsConstructTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int max = nums[l];
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfsConstructTree(nums, l, index - 1);
        root.right = dfsConstructTree(nums, index + 1, r);
        return root;
    }
}