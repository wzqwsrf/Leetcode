
// Flatten Binary Tree to Linked List

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:10:46
 * @url:https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */

//解法一
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        preOrder(list, root);
        int size = list.size();
        TreeNode point = root;
        for (int i = 1; i < size; i++) {
            point.right = new TreeNode(list.get(i));
            point.left = null;
            point = point.right;
        }
    }

    public void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left != null) {
            preOrder(list, root.left);
        }
        if (root.right != null) {
            preOrder(list, root.right);
        }
    }
}

//解法二
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (lastNode != null) {
                lastNode.left = null;
                lastNode.right = node;
            }
            lastNode = node;
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
        }
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */