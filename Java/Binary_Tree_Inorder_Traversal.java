
// Binary Tree Inorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:30:35
 * @url:https://leetcode.com/problems/binary-tree-inorder-traversal/
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
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
}