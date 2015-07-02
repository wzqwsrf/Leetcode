
// Candy

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:24:38
 * @url:https://leetcode.com/problems/candy/
 */

public class Solution {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int candyNum[] = new int[len];
        for (int i = 0; i < len; i++) {
            candyNum[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
                candyNum[i] = candyNum[i + 1] + 1;
            }
        }
        int allCandy = 0;
        for (int i = 0; i < len; i++) {
            allCandy += candyNum[i];
        }
        return allCandy;
    }
}