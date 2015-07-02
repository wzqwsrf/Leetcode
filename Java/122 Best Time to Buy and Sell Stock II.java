
// Best Time to Buy and Sell Stock II

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:14:21
 * @url:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            int tempProfit = prices[i] - prices[i - 1];
            if (tempProfit > 0) {
                maxProfit += tempProfit;
            }
        }
        return maxProfit;
    }
}