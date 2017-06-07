
// 556. Next Greater Element III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-8 00:30:51
 * @url:https://leetcode.com/problems/next-greater-element-iii/#/description
 */

public class Solution {
    public int nextGreaterElement(int n) {
        String s = n + "";
        char sArr[] = s.toCharArray();
        int len = s.length();
        int i = len - 1;
        while (i > 0) {
            if (sArr[i - 1] < sArr[i]) {
                break;
            }
            i--;
        }
        if (i == 0) {
            return -1;
        }
        int pos = sArr[i - 1];
        int min = i;
        for (int j = i + 1; j < len; j++) {
            if (sArr[j] > pos && sArr[j] < sArr[min]) {
                min = j;
            }
        }
        char temp = sArr[min];
        sArr[min] = sArr[i - 1];
        sArr[i - 1] = temp;
        Arrays.sort(sArr, i, len);
        long gn = Long.parseLong(String.valueOf(sArr));
        return gn < Integer.MAX_VALUE ? (int) gn : -1;
    }
}