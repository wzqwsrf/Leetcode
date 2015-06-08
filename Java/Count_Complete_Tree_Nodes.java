
//Count Complete Tree Nodes

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年06月08日11:09:18
 * @url:https://leetcode.com/problems/count-complete-tree-nodes/
 */

public class Count_Complete_Tree_Nodes {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *    int val;
     *    TreeNode left;
     *    TreeNode right;
     *    TreeNode(int x) { val = x; }
     * }
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lNum = getLeft(root.left) + 1;
        int rNum = getRight(root.right) + 1;
        if (lNum == rNum) {
            return (2 << (lNum - 1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int getLeft(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int getRight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}