
//Unique Binary Search Trees II

import java.util.ArrayList;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:29:16
 * @url:https://leetcode.com/problems/unique-binary-search-trees-ii/
 */

public class Unique_Binary_Search_Trees_II {

    public ArrayList<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private ArrayList<TreeNode> dfs(int start, int end) {
        ArrayList<TreeNode> numList = new ArrayList<TreeNode>();
        if (start > end) {
            TreeNode node = null;
            numList.add(node);
            return numList;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            numList.add(node);
            return numList;
        }

        for (int i = start; i <= end; i++) {
            TreeNode node = null;
            ArrayList<TreeNode> numList1 = dfs(start, i - 1);
            ArrayList<TreeNode> numList2 = dfs(i + 1, end);
            int size1 = numList1.size();
            int size2 = numList2.size();
            for (int j = 0; j < size1; j++) {
                for (int k = 0; k < size2; k++) {
                    node = new TreeNode(i);
                    node.left = numList1.get(j);
                    node.right = numList2.get(k);
                    numList.add(node);
                }
            }
        }
        return numList;
    }
}