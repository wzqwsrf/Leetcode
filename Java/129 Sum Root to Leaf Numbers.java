
// Sum Root to Leaf Numbers

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:37:36
 * @url:https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class Solution {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<String> numList = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(root, numList ,sb);
        int size = numList.size();
        int result = 0;
        for(int i = 0; i < size; i++){
            result += Integer.parseInt(numList.get(i));
        }
        return result;
    }
    public void dfs(TreeNode point, List<String> numList , StringBuffer sb){
        if (point == null) {
            return;
        }
        if(point.left == null && point.right == null){
            sb.append(point.val);
            String tempStr = sb.toString();
            numList.add(tempStr);
            return;
        }
        StringBuffer newsb = new StringBuffer(sb);
        sb.append(point.val);
        dfs(point.left, numList, sb);
        newsb.append(point.val);
        dfs(point.right, numList, newsb);
    }
}