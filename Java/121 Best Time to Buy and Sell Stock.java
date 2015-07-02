
// Best Time to Buy and Sell Stock

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:14:01
 * @url:https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            int tempProfit = prices[i] - min;
            if (maxProfit < tempProfit) {
                maxProfit = tempProfit;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return maxProfit;
    }
}