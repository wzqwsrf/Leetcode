
// Lowest Common Ancestor of a Binary Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-13 16:27:56
 * @url:https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 具体参考csdn:http://blog.csdn.net/u013027996/article/details/46865757
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();
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

    private boolean getPath(TreeNode root, TreeNode d, List<TreeNode> list) {
        if (root == d) {
            list.add(root);
            return true;
        }
        if (root != null) {
            list.add(root);
            if (getPath(root.left, d, list) || getPath(root.right, d, list)) {
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