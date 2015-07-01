
// Unique Binary Search Trees

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:28:24
 * @url:https://leetcode.com/problems/unique-binary-search-trees/
 */

public class Solution {

    public int numTrees(int n) {
        return addAllNum(1, n);
    }

    private int addAllNum(int start, int end) {
        if (start >= end) {
            return 1;
        }
        int allNum = 0;
        for (int i = start; i <= end; i++) {
            allNum += addAllNum(start, i - 1) * addAllNum(i + 1, end);
        }
        return allNum;
    }
}