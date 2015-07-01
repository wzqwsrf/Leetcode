
// Validate Binary Search Tree

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月11日12:15:30
 * @url:https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 1、二叉搜索树的基本判断，左孩子比根值小，右孩子比根值大。
 * 2、按照这个思路，默认的最大最小值是int的值范围。
 * 3、递归判断，每次判断左右孩子的值和最大最小值的比较。
 * 4、一直到根为空，递归结束。
 * 具体参考http://blog.csdn.net/u013027996/article/details/37692581
 */

public class Solution {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
