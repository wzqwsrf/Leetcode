
// 530. Minimum Absolute Difference in BST

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:39:21
 * @url:https://leetcode.com/problems/minimum-absolute-difference-in-bst/#/description
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
    private int minDiff;
    private List<Integer> list;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        list = new ArrayList<Integer>();
        inOrderBST(root);
        int size = list.size();
        int i = 1;
        while (i < size) {
            int diff = list.get(i) - list.get(i - 1);
            minDiff = minDiff > diff ? diff : minDiff;
            i++;
        }
        return minDiff;
    }

    private void inOrderBST(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderBST(root.left);
        list.add(root.val);
        inOrderBST(root.right);
    }
}

public class Solution {
    private int minDiff;
    private TreeNode preNode;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inOrderBST(root);
        return minDiff;
    }

    private void inOrderBST(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderBST(root.left);
        if (preNode != null) {
            minDiff = Math.min(minDiff, root.val - preNode.val);
        }
        preNode = root;
        inOrderBST(root.right);
    }
}