
// Subsets

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:09:29
 * @url:https://leetcode.com/problems/subsets/
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int len;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) {
            return list;
        }
        len = S.length;
        Arrays.sort(S);
        for (int i = 1; i < len + 1; i++) {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            dfs(list, numList, S, 0, i);
        }
        list.add(new ArrayList<Integer>());
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list,
                    ArrayList<Integer> numList, int[] S, int start, int k) {
        if (numList.size() == k) {
            list.add(new ArrayList<Integer>(numList));
            return;
        }
        ArrayList<Integer> allList = new ArrayList<Integer>();
        for (int i = start; i < len; i++) {
            if (allList.contains(S[i])) {
                continue;
            }
            allList.add(S[i]);
            numList.add(S[i]);
            dfs(list, numList, S, i + 1, k);
            numList.remove(numList.size() - 1);
        }
    }
}