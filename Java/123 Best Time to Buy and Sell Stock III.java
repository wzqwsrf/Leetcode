
// Best Time to Buy and Sell Stock III

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 17:14:58
 * @url:https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        int min = prices[0];
        int arrayA[] = new int[len];
        for (int i = 1; i < len; i++) {
            arrayA[i] = prices[i] - min;
            arrayA[i] = arrayA[i] > arrayA[i - 1] ? arrayA[i] : arrayA[i - 1];
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        int max = prices[len - 1];
        int arrayB[] = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            arrayB[i] = max - prices[i];
            arrayB[i] = arrayB[i] > arrayB[i + 1] ? arrayB[i] : arrayB[i + 1];
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        for (int i = 0; i < len; i++) {
            int tempValue = arrayA[i] + arrayB[i];
            maxProfit = maxProfit > tempValue ? maxProfit : tempValue;
        }
        return maxProfit;
    }
}