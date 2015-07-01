
// Subsets II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年05月28日17:21:32
 * @url:https://leetcode.com/problems/subsets-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int len;

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return list;
        }
        len = num.length;
        Arrays.sort(num);
        for (int i = 1; i < len + 1; i++) {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            dfs(list, numList, num, 0, i);
        }
        list.add(new ArrayList<Integer>());
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list,
                    ArrayList<Integer> numList, int[] num, int start, int k) {
        if (numList.size() == k) {
            list.add(new ArrayList<Integer>(numList));
            return;
        }
        ArrayList<Integer> allList = new ArrayList<Integer>();
        for (int i = start; i < len; i++) {
            if (allList.contains(num[i])) {
                continue;
            }
            allList.add(num[i]);
            numList.add(num[i]);
            dfs(list, numList, num, i + 1, k);
            numList.remove(numList.size() - 1);
        }
    }
}