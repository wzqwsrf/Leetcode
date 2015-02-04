
// Permutations II

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：
 * Given a collection of numbers that might contain duplicates,
 * return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日11:50:25
 * @url:https://oj.leetcode.com/problems/permutations-ii/
 * 全排列，带有重复数据，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18734103
 */

//方法一，下一个全排列，经典算法
public class Permutations_II {
    public ArrayList<ArrayList<Integer>> list;

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return list;
        }
        int len = num.length;
        Arrays.sort(num);
        nextpermutation(num, len);
        return list;
    }

    public void nextpermutation(int[] num, int len) {
        while (true) {
            ArrayList<Integer> numList = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                numList.add(num[i]);
            }
            list.add(numList);
            int first = getFirst(num, len);
            if (first == -1) {
                break;
            }
            int i = len - 1;
            for (; i > first; i--) {
                if (num[i] > num[first]) {
                    break;
                }
            }
            swap(num, i, first);
            reverse(num, first + 1, len - 1);
        }
    }

    public int getFirst(int[] num, int len) {
        for (int i = len - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int[] num, int low, int high) {
        int temp = num[low];
        num[low] = num[high];
        num[high] = temp;
    }

    public void reverse(int[] num, int low, int high) {
        while (low < high) {
            swap(num, low, high);
            low++;
            high--;
        }
    }
}


//方法二，1、DFS，先排列再考察相邻的两个数是否相等，相等的话，就不重复回溯
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return list;
        }
        int len = num.length;
        int visit[] = new int[len];
        ArrayList<Integer> numList = new ArrayList<Integer>();
        Arrays.sort(num);
        dfs(list, numList, num, visit, len);
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list,
                    ArrayList<Integer> numList, int[] num, int[] visit, int len) {
        if (numList.size() == len) {
            list.add(new ArrayList<Integer>(numList));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                numList.add(num[i]);
                dfs(list, numList, num, visit, len);
                numList.remove(numList.size() - 1);
                visit[i] = 0;
                while (i < len - 1 && num[i] == num[i + 1]) {
                    i++;
                }
            }
        }
    }
}

//方法二，2、DFS，考察本次回溯中是否从同一个数开始回溯，如果是的话，就不重复回溯
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) {
            return list;
        }
        int len = num.length;
        int visit[] = new int[len];
        ArrayList<Integer> numList = new ArrayList<Integer>();
        dfs(list, numList, num, visit, len);
        return list;
    }

    public void dfs(ArrayList<ArrayList<Integer>> list,
                    ArrayList<Integer> numList, int[] num, int[] visit, int len) {
        if (numList.size() == len) {
            list.add(new ArrayList<Integer>(numList));
            return;
        }
        List<Integer> usedList = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            if (visit[i] == 0) {
                if (usedList.contains(num[i])) {
                    continue;
                } else {
                    usedList.add(num[i]);
                }
                visit[i] = 1;
                numList.add(num[i]);
                dfs(list, numList, num, visit, len);
                numList.remove(numList.size() - 1);
                visit[i] = 0;
            }
        }
    }
}