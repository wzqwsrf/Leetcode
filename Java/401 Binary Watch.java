
// 401. Binary Watch

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-8-10 16:24:08
 * @url:https://leetcode.com/problems/binary-watch/description/
 */

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return list;
    }
}