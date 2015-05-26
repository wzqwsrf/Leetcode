
// Combination Sum III 236ms

import java.util.*;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2014年07月02日17:25:17
 * @url:https://leetcode.com/problems/contains-duplicate/
 * 递归经典案例
 */

public class Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> numList = new ArrayList<Integer>();
        dfs(list, numList, 1, 0, 0, k, n);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> numList,
                    int start, int sum, int num, int k, int n) {
        if (sum == n && num == k) {
            ArrayList<Integer> tempList = new ArrayList<Integer>(numList);
            Collections.sort(tempList);
            list.add(tempList);
            return;
        }
        ArrayList<Integer> reList = new ArrayList<Integer>();
        for (int i = start; i < 10; i++) {
            int tempSum = sum + i;
            int tempNum = num + 1;
            if (tempSum <= n && tempNum <= k) {
                if (!reList.contains(i)) {
                    reList.add(i);
                } else {
                    continue;
                }
                numList.add(i);
                dfs(list, numList, i + 1, tempSum, tempNum, k, n);
                numList.remove(numList.size() - 1);
            }
        }
    }
}
