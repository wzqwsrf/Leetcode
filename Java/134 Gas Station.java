
// Gas Station

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015-07-02 16:27:04
 * @url:https://leetcode.com/problems/gas-station/
 */

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return 0;
        }
        int len = gas.length;
        int index = -1;
        int total = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                index = i;
            }
        }
        if (total < 0) {
            return -1;
        }
        return index + 1;
    }
}