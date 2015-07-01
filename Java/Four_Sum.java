
// 4Sum

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:09:26
 * @url:https://leetcode.com/problems/4sum/
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                getTargetNum(list, num, i, j, j + 1, len - 1, len, target);
            }
        }
        return list;
    }

    public void getTargetNum(ArrayList<ArrayList<Integer>> list,
                             int[] num, int first, int second,
                             int low, int high, int len, int target) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int tempValue = (num[first] + num[second]);
        while (low < high) {
            if (tempValue + num[low] + num[high] > target) {
                high--;
            } else if (tempValue + num[low] + num[high] < target) {
                low++;
            } else {
                numList.add(num[first]);
                numList.add(num[second]);
                numList.add(num[low]);
                numList.add(num[high]);
                list.add(new ArrayList<Integer>(numList));
                numList.clear();
                int tempLow = low;
                int tempHigh = high;
                low++;
                high--;
                while (low < len && num[low] == num[tempLow]) {
                    low++;
                }
                while (high >= 0 && num[high] == num[tempHigh]) {
                    high--;
                }
            }
        }
    }
}