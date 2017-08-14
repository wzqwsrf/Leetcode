
// 145. Binary Tree Postorder Traversal

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:16:01
 * @update:2017-8-14 22:59:07
 * @url:https://leetcode.com/problems/binary-tree-postorder-traversal/
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private ArrayList<Integer> list;

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        postOrder(root);
        return list;
    }

    private void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                list.add(node.val);
                continue;
            }
            TreeNode right = node.right;
            node.left = null;
            node.right = null;
            stack.push(node);
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
    }
}