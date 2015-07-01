
// Binary Tree Preorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:17:07
 * @url:https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    private ArrayList<Integer> list;

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        preOrder(root);
        return list;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}