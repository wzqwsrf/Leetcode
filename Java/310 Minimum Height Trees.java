
// Minimum Height Trees

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-12-01 19:31:43
 * @url:https://leetcode.com/problems/minimum-height-trees/
 */

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> list = new ArrayList<Integer>();
        if (n <= 0) {
            return list;
        }
        if (n == 1) {
            list.add(0);
            return list;
        }
        HashSet<Integer>[] array = new HashSet[n];
        for (int i = 0; i < n; i++) {
            array[i] = new HashSet<Integer>();
        }
        for (int[] edge : edges) {
            array[edge[0]].add(edge[1]);
            array[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (array[i].size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (int i : leaves) {
                int j = array[i].iterator().next();
                array[j].remove(i);
                if (array[j].size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}