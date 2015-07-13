
// Lowest Common Ancestor of a Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-13 16:27:56
 * @url:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class Solution {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        list1.add(root);
        list2.add(root);
        getPath(root, p, list1);
        getPath(root, q, list2);
        int size1 = list1.size();
        int size2 = list2.size();
        int len = size1 < size2 ? size1 : size2;
        int k = 0;
        while (k < len) {
            TreeNode node1 = list1.get(k);
            TreeNode node2 = list2.get(k);
            if (node1 != node2) {
                break;
            }
            k++;
        }
        return list1.get(k - 1);
    }

    private static boolean getPath(TreeNode root, TreeNode d, List<TreeNode> list) {
        if (root == d) {
            return true;
        }
        if (root.left != null) {
            list.add(root.left);
            if (getPath(root.left, d, list)) {
                return true;
            }
            list.remove(list.size() - 1);

        }
        if (root.right != null) {
            list.add(root.right);
            if (getPath(root.right, d, list)) {
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */