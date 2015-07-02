
// Longest Consecutive Sequence

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:16:34
 * @url:https://leetcode.com/problems/longest-consecutive-sequence/
 */

//解法一
public class Solution {

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int len = num.length;
        int maxNum = num[0];
        int minNum = num[0];
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            numSet.add(num[i]);
            if (num[i] > maxNum) {
                maxNum = num[i];
            }
            if (num[i] < minNum) {
                minNum = num[i];
            }
        }
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            if (numSet.isEmpty()) {
                break;
            }
            if (!numSet.contains(num[i])) {
                continue;
            }
            numSet.remove(num[i]);
            int tempLen = 1;
            for (int j = 1; j <= maxNum - num[i]; j++) {
                if (numSet.contains(num[i] + j)) {
                    numSet.remove(num[i] + j);
                    tempLen++;
                } else {
                    break;
                }
            }
            for (int j = 1; j <= Math.abs(num[i] - minNum); j++) {
                if (numSet.contains(num[i] - j)) {
                    numSet.remove(num[i] - j);
                    tempLen++;
                } else {
                    break;
                }
            }
            if (tempLen > maxLen) {
                maxLen = tempLen;
            }
        }
        return maxLen;
    }
}

//解法二
public class Solution {

    public HashSet<Integer> numSet;

    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int len = num.length;
        int maxNum = num[0];
        numSet = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            numSet.add(num[i]);
        }
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            int tempLen = 1;
            if (numSet.contains(num[i])) {
                tempLen += getCount(num[i] + 1, 1);
                tempLen += getCount(num[i] - 1, 2);
            }
            if (tempLen > maxLen) {
                maxLen = tempLen;
            }
        }
        return maxLen;
    }

    public int getCount(int curNum, int seq) {
        int count = 0;
        while (numSet.contains(curNum)) {
            numSet.remove(curNum);
            if (seq == 1) {
                curNum++;
            } else {
                curNum--;
            }
            count++;
        }
        return count;
    }
}