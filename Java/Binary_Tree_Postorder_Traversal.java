
//Binary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月29日17:16:01
 * @url:https://leetcode.com/problems/binary-tree-postorder-traversal/
 */

public class Binary_Tree_Postorder_Traversal {
    private ArrayList<Integer> list;
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        list = new ArrayList<Integer>();
        postOrder(root);
        return list;
    }
    private void postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            while(!stack.isEmpty()){
                root = stack.pop();
                if(root.right != null){
                    stack.push(new TreeNode(root.val));
                    root = root.right;
                    break;
                }
                list.add(root.val);
                if (stack.isEmpty()) {
                    return;
                }
            }
        }
    }
}