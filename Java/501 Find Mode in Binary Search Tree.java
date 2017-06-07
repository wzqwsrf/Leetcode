
// 501. Find Mode in Binary Search Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-7 12:35:58
 * @url:https://leetcode.com/problems/find-mode-in-binary-search-tree/#/description
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
    private int max;
    private int count;
    private TreeNode preNode;
    private List<Integer> list;

    public int[] findMode(TreeNode root) {
        max = Integer.MIN_VALUE;
        count = 1;
        list = new ArrayList<>();
        inOrder(root);
        int size = list.size();
        int array[] = new int[size];
        int i = 0;
        for (Integer val : list) {
            array[i++] = val;
        }
        return array;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (preNode != null) {
            if (preNode.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        preNode = root;
        inOrder(root.right);
    }
}