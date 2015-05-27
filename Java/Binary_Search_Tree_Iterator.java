
// Binary Search Tree Iterator 400ms

import java.util.*;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月27日10:48:34
 * @url:https://leetcode.com/problems/binary-search-tree-iterator/
 */

public class Binary_Search_Tree_Iterator {
    private Queue<Integer> queue;

    public Binary_Search_Tree_Iterator(TreeNode root) {
        queue = new LinkedList<Integer>();
        inOrderTreeNode(root);
    }

    public void inOrderTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTreeNode(root.left);
        queue.add(root.val);
        inOrderTreeNode(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        if (hasNext()) {
            return queue.poll();
        }
        return -1;
    }

//    22222
//    private Stack<TreeNode> stack;
//
//    public Binary_Search_Tree_Iterator(TreeNode root) {
//        stack = new Stack<TreeNode>();
//        TreeNode p = root;
//        while(p != null){
//            stack.push(p);
//            p = p.left;
//        }
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        if(!stack.isEmpty()){
//            TreeNode p = stack.pop();
//            int val = p.val;
//            if(p.right != null){
//                TreeNode node = p.right;
//                while(node != null){
//                    stack.push(node);
//                    node = node.left;
//                }
//            }
//            return val;
//        }
//        return -1;
//    }
}
