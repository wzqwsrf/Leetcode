
// Happy Number

/**
 * @author:wangzq
 * @email:wangzhenqing1008@163.com
 * @date:2015年04月22日23:39:57
 * @url:https://leetcode.com/problems/happy-number/
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isHappy(int n) {
        List<Integer> numList = new ArrayList<Integer>();
        while (n != 1) {
            int newN = n;
            int num = 0;
            while (newN > 0) {
                int tempNum = newN % 10;
                newN /= 10;
                num += Math.pow(tempNum, 2);
            }
            if (numList.contains(num)) {
                break;
            } else {
                numList.add(num);
            }
            n = num;
        }
        return n == 1;
    }
}