
// Combinations

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:08:41
 * @url:https://leetcode.com/problems/combinations/
 */

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        dfs(list, numList, n, k, 1);
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> numList,
                    int n, int k, int start) {
        if (numList.size() == k) {
            list.add(new ArrayList<Integer>(numList));
            return;
        }
        for (int i = start; i <= n; i++) {
            numList.add(i);
            dfs(list, numList, n, k, i + 1);
            numList.remove(numList.size() - 1);
        }
    }
}