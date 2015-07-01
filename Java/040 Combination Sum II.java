
// Combination Sum II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日22:56:31
 * @url:https://leetcode.com/problems/combination-sum-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    private int len = 0;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return list;
        }
        Arrays.sort(candidates);
        len = candidates.length;
        ArrayList<Integer> numList = new ArrayList<Integer>();
        dfs(list, numList, candidates, 0, 0, target);
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> numList,
                    int[] candidates, int start, int sum, int target) {
        if (sum == target) {
            ArrayList<Integer> tempList = new ArrayList<Integer>(numList);
            Collections.sort(tempList);
            list.add(tempList);
            return;
        }
        ArrayList<Integer> reList = new ArrayList<Integer>();
        for (int i = start; i < len; i++) {
            int tempSum = sum + candidates[i];
            if (tempSum <= target) {
                if (!reList.contains(candidates[i])) {
                    reList.add(candidates[i]);
                } else {
                    continue;
                }
                numList.add(candidates[i]);
                dfs(list, numList, candidates, i + 1, tempSum, target);
                numList.remove(numList.size() - 1);
            }
        }
    }
}