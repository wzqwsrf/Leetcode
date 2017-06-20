
// 624. Maximum Distance in Arrays

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-20 14:44:07
 * @url:https://leetcode.com/problems/maximum-distance-in-arrays/#/description
 */

public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int size = arrays.size();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int xpos = 0;
        int npos = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> list = arrays.get(i);
            if (list.get(0) < min) {
                min = list.get(0);
                npos = i;
            }
            int lsize = list.size();
            if (list.get(lsize - 1) > max) {
                max = list.get(lsize - 1);
                xpos = i;
            }
        }
        if (npos != xpos) {
            return max - min;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            List<Integer> list = arrays.get(i);
            if (i != npos) {
                int tempMax = max - list.get(0);
                result = result > tempMax ? result : tempMax;
            }
            int lsize = list.size();
            if (list.get(lsize - 1) > max) {
                max = list.get(lsize - 1);
                xpos = i;
            }
            if (i != xpos) {
                int tempMax = list.get(lsize - 1) - min;
                result = result > tempMax ? result : tempMax;
            }
        }
        return result;
    }
}