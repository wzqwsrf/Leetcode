
// Permutations 268ms

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目：
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

/*
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月04日09:55:46
 * @url:https://oj.leetcode.com/problems/permutations/
 * 全排列，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18734103
 */

//方法一
public class Permutations {
    public ArrayList<ArrayList<Integer>> list;

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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

//方法二
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
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
        for (int i = 0; i < len; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                numList.add(num[i]);
                dfs(list, numList, num, visit, len);
                numList.remove(numList.size() - 1);
                visit[i] = 0;
            }
        }
    }
}