
// ZigZag Conversion

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月14日21:52:18
 * @url:https://leetcode.com/problems/zigzag-conversion/
 * 具体参考
 */

public class Solution {

    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        char array[] = s.toCharArray();
        int rowLen = 2 * nRows - 2;
        int colLen = rowLen + 2;
        for (int i = 0; i < nRows; i++) {
            int j = i;
            colLen -= 2;
            while (j < len) {
                if (i == 0 || i == nRows - 1) {
                    sb.append(String.valueOf(array[j]));
                    j += rowLen;
                } else {
                    sb.append(String.valueOf(array[j]));
                    int tempLen = j + colLen;
                    if (tempLen < len) {
                        sb.append(String.valueOf(array[tempLen]));
                    }
                    j += rowLen;
                }
            }
        }
        return sb.toString();
    }
}