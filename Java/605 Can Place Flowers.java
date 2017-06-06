
// 605. Can Place Flowers

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2017-6-6 17:47:32
 * @url:https://leetcode.com/problems/can-place-flowers/#/description
 */

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1) {
            return n == 0 || flowerbed[0] != n;
        }
        int count = 0;
        int start = 0;
        int end = 0;
        if (flowerbed[0] == 1) {
            end = 1;
        }
        while (end < len) {
            boolean flag = false;
            while (flowerbed[end] == 0) {
                end++;
                if (end >= len) {
                    flag = true;
                    break;
                }
            }
            int last = flag ? 0 : 1;
            int currLen = end - start;
            currLen = flag ? currLen : currLen + 1;
            count += currLen - currLen / 2
                    - flowerbed[start]
                    - last;
            if (count >= n) {
                return true;
            }
            start = end;
            end++;
        }
        return false;
    }
}