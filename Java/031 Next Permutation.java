
// Next Permutation

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年02月03日10:17:11
 * @url:https://oj.leetcode.com/problems/next-permutation/
 * 全排列，经典算法
 * 具体参考：http://blog.csdn.net/u013027996/article/details/18732185
 */

public class Solution {

    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        int len = num.length;
        int first = getFirst(num);
        if (first == -1) {
            reverse(num, 0, len - 1);
        } else {
            int i = len - 1;
            for (; i > first; i--) {
                if (num[i] > num[first]) {
                    break;
                }
            }
            swap(num, first, i);
            reverse(num, first + 1, len - 1);
        }
    }

    public int getFirst(int[] num) {
        int len = num.length;
        for (int i = len - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public void reverse(int[] num, int low, int high) {
        while (low < high) {
            swap(num, low, high);
            low++;
            high--;
        }
    }
}

