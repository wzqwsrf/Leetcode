
// Binary Tree Inorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:30:35
 * @update:2017-8-14 23:00:00
 * @url:https://leetcode.com/problems/binary-tree-inorder-traversal/
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    private ArrayList<Integer> list;

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        inOrder(root);
        return list;
    }

    private void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
    }
}