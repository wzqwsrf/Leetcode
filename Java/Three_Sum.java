
// 3Sum

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月19日22:04:30
 * @url:https://leetcode.com/problems/3sum/
 */

public class Three_Sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> list =
                new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        Arrays.sort(num);
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            getTargetNum(list, num, i, i + 1, len - 1, len);
        }
        return list;
    }

    public void getTargetNum(ArrayList<ArrayList<Integer>> list,
                             int[] num, int first,
                             int low, int high, int len) {
        int target = num[first] * -1;
        ArrayList<Integer> numList = new ArrayList<Integer>();
        while (low < high) {
            if (num[low] + num[high] > target) {
                high--;
            } else if (num[low] + num[high] < target) {
                low++;
            } else {
                numList.add(num[first]);
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